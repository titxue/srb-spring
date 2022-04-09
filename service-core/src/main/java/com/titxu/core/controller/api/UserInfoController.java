package com.titxu.core.controller.api;


import com.titxu.base.pojo.dto.SmsDTORequest;
import com.titxu.base.pojo.enums.Platform;
import com.titxu.base.pojo.enums.SmsLengthEnum;
import com.titxu.base.utils.RedisUtils;
import com.titxu.base.utils.SmsCodeUtil;
import com.titxu.common.exception.Assert;
import com.titxu.common.result.R;
import com.titxu.common.result.ResponseEnum;
import com.titxu.core.client.SmsClient;
import com.titxu.core.convert.UserInfoConvert;
import com.titxu.core.pojo.dto.UserInfoDtoRequest;
import com.titxu.core.pojo.vo.UserInfoRegisterVo;
import com.titxu.core.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户基本信息 前端控制器
 * </p>
 *
 * @author Lxue
 * @since 2022-03-22
 */
@RestController
@RequestMapping("/api/core/userInfo")
public class UserInfoController {
    private UserInfoService service;
    private UserInfoConvert convert;
    private RedisUtils redisUtils;
    private SmsClient smsClient;

    @GetMapping("/getUserInfo")
    public String getUserInfo() {
        return "getUserInfo";
    }

    @GetMapping("/checkMobile/{mobile}")
    public Boolean checkMobile(@PathVariable("mobile") String mobile) {
        return service.checkMobile(mobile);
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public R<UserInfoRegisterVo> register(@RequestBody @Validated UserInfoDtoRequest request) {
        // 检查验证码是否正确
        // 生成redis key
        String cacheKey = SmsCodeUtil.createSmsCacheKey("sms:code", request.getMobile(), "register");
        String code = (String) redisUtils.getCacheObject(cacheKey);
        // Assert.notEmpty(request.getCode(), ResponseEnum.CODE_NULL_ERROR);
        Assert.isTrue(code.equals(request.getCode()), ResponseEnum.CODE_ERROR);

        // 检查手机号是否已经注册
        Assert.isTrue(service.checkMobile(request.getMobile()), ResponseEnum.MOBILE_EXIST_ERROR);

        return R.ok().data(convert.toRegisterVo(service.register(convert.toRequestDto(request))));
    }

    @ApiOperation(value = "发送短信验证码")
    @PostMapping("/sendCode/{mobile}")
    public R<Boolean> sendCode(@PathVariable("mobile") String mobile) {
        // 检查手机号是否已经注册
        Assert.isTrue(!service.checkMobile(mobile), ResponseEnum.MOBILE_EXIST_ERROR);
        // 生成redis key
        String cacheKey = SmsCodeUtil.createSmsCacheKey("sms:code", mobile, "register");
        // 发送验证码
        String code = SmsCodeUtil.createSmsRandomCode(SmsLengthEnum.SMS_LENGTH_4);

        SmsDTORequest request = new SmsDTORequest();
        request.setCode(code);
        request.setPhone(mobile);
        request.setPlatform(Platform.Tencent);
        request.setType("register");

        smsClient.send(request);
        return R.ok().msg("验证码发送成功").data(true);
    }


    @Autowired
    public void setService(UserInfoService service) {
        this.service = service;
    }

    @Autowired
    public void setConvert(UserInfoConvert convert) {
        this.convert = convert;
    }

    @Autowired
    public void setSmsClient(SmsClient smsClient) {
        this.smsClient = smsClient;
    }

    @Autowired
    public void setRedisUtils(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }
}

