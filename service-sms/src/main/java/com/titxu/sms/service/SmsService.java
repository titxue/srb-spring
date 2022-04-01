package com.titxu.sms.service;

import com.titxu.sms.pojo.dto.SmsDTO;
import com.titxu.sms.pojo.dto.SmsDTORequest;
import com.titxu.sms.pojo.vo.SmsVO;

public interface SmsService {
    /**
     * 发送短信
     * @param smsDTO  发送请求
     */
    void sendSms(SmsDTO smsDTO);

    /**
     * 查询短信发送状态
     * @param smsDTO 查询请求
     * @return  发送结果 SmsVO
     */
    SmsVO querySmsStatus(SmsDTO smsDTO);


    /**
     * 验证短信验证码
     * @param smsDTO 验证码请求
     */
    void verifySms(SmsDTO smsDTO);
}
