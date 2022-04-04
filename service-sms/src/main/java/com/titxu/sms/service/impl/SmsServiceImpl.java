package com.titxu.sms.service.impl;

import com.titxu.base.utils.RedisUtils;
import com.titxu.sms.pojo.dto.SmsDTO;
import com.titxu.sms.pojo.enums.Platform;
import com.titxu.sms.pojo.vo.SmsVO;
import com.titxu.sms.service.SmsPlatformService;
import com.titxu.sms.service.SmsService;
import com.titxu.sms.utils.SmsCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;


@Slf4j
@Service
public class SmsServiceImpl implements SmsService {

    private RedisUtils redisUtils;

    private Map<String, SmsPlatformService> platformServices;

    @Override
    public void sendSms(SmsDTO smsDTO) {

        // Todo: 后台设置当前Storage
        smsDTO.setPlatform(getDefaultStorage());


        // 调用短信平台发送短信
        platformServices.get(smsDTO.getPlatform().name()).getSms(smsDTO);

        // 生成redis key
        String cacheKey = SmsCodeUtil.createSmsCacheKey("sms:code", smsDTO.getPhone(), smsDTO.getType());

        // 保存到redis
        redisUtils.setCacheObject(cacheKey,smsDTO.getCode(),60L, TimeUnit.SECONDS);
        log.info("code:{}",smsDTO.getCode());




    }

    @Override
    public SmsVO querySmsStatus(SmsDTO request) {
        return null;
    }

    @Override
    public void verifySms(SmsDTO request) {

    }


    // Todo: 后台设置当前Storage
    private Platform getDefaultStorage() {
        return Platform.Tencent;
    }



    public SmsServiceImpl(Map<String, SmsPlatformService> platformServices) {
        this.platformServices = platformServices;
    }

    @Autowired
    public void setRedisUtils(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }
}
