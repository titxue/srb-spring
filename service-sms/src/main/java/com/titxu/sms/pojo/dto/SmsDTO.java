package com.titxu.sms.pojo.dto;

import com.titxu.sms.pojo.enums.Platform;
import lombok.Data;

@Data
public class SmsDTO {
    private String phone; // 手机号
    private String code; //验证码
    private String type="register"; //register:注册 forgot:忘记密码
    private Platform platform; //平台

}
