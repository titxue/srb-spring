package com.titxu.sms;


import com.titxu.base.pojo.dto.SmsDTO;
import com.titxu.sms.properties.SmsProperties;
import com.titxu.sms.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@Slf4j
@SpringBootTest(classes = ApplicationSms.class)
public class SmsTest {

    @Resource
    private SmsService service;

    @Test
    public void testProperties() {
        log.info("APP_ID:{}",SmsProperties.APP_ID);
        log.info("SECRET_ID:{}",SmsProperties.SECRET_ID);
        log.info("SECRET_KEY:{}",SmsProperties.SECRET_KEY);
        log.info("TEMPLATE_ID:{}",SmsProperties.TEMPLATE_ID);
        log.info("SMS_NAME:{}",SmsProperties.SIGN_NAME);
        // Assert.notEmpty(SmsProperties.APP_ID, ResponseEnum.APP_ID_EMPTY);
        // Assert.notEmpty(SmsProperties.SECRET_ID,ResponseEnum.SECRET_ID_EMPTY);
        // Assert.notEmpty(SmsProperties.SECRET_KEY,ResponseEnum.SECRET_KEY_EMPTY);
        // Assert.notEmpty(SmsProperties.TEMPLATE_ID,ResponseEnum.TEMPLATE_ID_EMPTY);
        // Assert.notEmpty(SmsProperties.SMS_NAME,ResponseEnum.SMS_NAME_EMPTY);

    }
    @Test
    void testSmsService(){
        SmsDTO dto = new SmsDTO();
        dto.setCode("1236");
        dto.setPhone("17339493439");
        dto.setType("register");
        service.sendSms(dto);
    }


}
