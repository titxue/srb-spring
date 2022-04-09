package com.titxu.sms.convert;


import com.titxu.base.pojo.dto.SmsDTO;
import com.titxu.base.pojo.dto.SmsDTORequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SmsConvert {
    SmsDTO toDTO(SmsDTORequest request);
}
