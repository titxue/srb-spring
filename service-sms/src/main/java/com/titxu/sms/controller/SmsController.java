package com.titxu.sms.controller;


import com.titxu.common.result.R;
import com.titxu.sms.convert.SmsConvert;
import com.titxu.sms.pojo.dto.SmsDTO;
import com.titxu.sms.pojo.dto.SmsDTORequest;
import com.titxu.sms.pojo.enums.SmsLengthEnum;
import com.titxu.sms.service.SmsService;
import com.titxu.sms.utils.SmsCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sms")
public class SmsController {


    private SmsService service;
    private SmsConvert convert;


    @PostMapping("/send")
    public R<Object> send(@RequestBody @Validated SmsDTORequest request){
        SmsDTO dto = convert.toDTO(request);
        dto.setCode(SmsCodeUtil.createSmsRandomCode(SmsLengthEnum.SMS_LENGTH_4));
        dto.setType("register");
        service.sendSms(dto);
        return R.ok();
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
