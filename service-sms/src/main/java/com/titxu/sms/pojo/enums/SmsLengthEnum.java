package com.titxu.sms.pojo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SmsLengthEnum {

    /** 4位短信验证码 */
    SMS_LENGTH_4(4),
    /** 6位短信验证码 */
    SMS_LENGTH_6(6),

    ;

    private int length;
}