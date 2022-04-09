package com.titxu.sms.controller;


import com.titxu.base.pojo.dto.SmsDTO;
import com.titxu.base.pojo.dto.SmsDTORequest;
import com.titxu.base.utils.SmsCodeUtil;
import com.titxu.sms.convert.SmsConvert;
import com.titxu.base.pojo.enums.SmsLengthEnum;
import com.titxu.sms.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sms")
public class SmsController {


    private SmsService service;
    private SmsConvert convert;


    @PostMapping("/send")
    public void send(@RequestBody @Validated SmsDTORequest request) {
        SmsDTO dto = convert.toDTO(request);
        if (dto.getCode() == null) {
            dto.setCode(SmsCodeUtil.createSmsRandomCode(SmsLengthEnum.SMS_LENGTH_4));
        }
        service.sendSms(dto);
    }

    @Autowired
    public void setService(SmsService service) {
        this.service = service;
    }

    @Autowired
    public void setConvert(SmsConvert convert) {
        this.convert = convert;
    }
}
