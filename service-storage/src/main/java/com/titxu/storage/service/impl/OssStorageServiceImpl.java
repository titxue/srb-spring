package com.titxu.storage.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.titxu.common.exception.BusinessException;
import com.titxu.common.result.ResponseEnum;
import com.titxu.storage.pojo.dto.FileUploadDto;
import com.titxu.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("OSS")
@Slf4j
public class OssStorageServiceImpl implements StorageService {

    @Value("${aliyun.oss.secret_id}")
    private String secretId;
    @Value("${aliyun.oss.secret_key}")
    private String secretKey;
    @Value("${aliyun.oss.bucket}")
    private String bucket;

    @Value("${aliyun.oss.region}")
    private String region;

    @Value("${aliyun.oss.role_arn}")
    private String roleArn;

    @Value("${aliyun.oss.role_name}")
    private String roleSessionName;


    @Override
    public FileUploadDto getScrip() {

        try {
            // 构造default profile。
            IClientProfile profile = DefaultProfile.getProfile(region, secretId, secretKey);

            // 构造client。
            DefaultAcsClient client = new DefaultAcsClient(profile);
            final AssumeRoleRequest request = new AssumeRoleRequest();
            // 适用于Java SDK 3.12.0及以上版本。
            request.setSysMethod(MethodType.POST);
            request.setRoleArn(roleArn);
            request.setRoleSessionName(roleSessionName);
            request.setDurationSeconds(3600L); // 设置临时访问凭证的有效时间为3600秒。
            final AssumeRoleResponse response = client.getAcsResponse(request);


            // 创建 FileUploadDto
            FileUploadDto uploadDto = new FileUploadDto();
            uploadDto.setBucket(bucket);
            uploadDto.setRegion(region);
            uploadDto.setSecretId(response.getCredentials().getAccessKeyId());
            uploadDto.setSecretKey(response.getCredentials().getAccessKeySecret());
            uploadDto.setSessionToken(response.getCredentials().getSecurityToken());

            Date parse = DateUtil.parse(response.getCredentials().getExpiration());
            // 偏移时间7个小时  Z(0)时区 -> +8 小时为北京时间 || 返回的时间比正常时间的多一个小时正常
            DateTime dateTime = DateUtil.offsetHour(parse, 8);
            log.info("时间戳:{}",parse.getTime());
            log.info("东八区时间:{}", dateTime);
            // 时间戳不用偏移处理
            uploadDto.setExpiration(parse.getTime());
            uploadDto.setRequestId(response.getRequestId());
            return uploadDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(ResponseEnum.FETCH_UPLOAD_AUTH_ERROR);
        }
    }
}
