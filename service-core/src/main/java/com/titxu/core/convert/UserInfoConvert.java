package com.titxu.core.convert;

import com.titxu.core.pojo.dto.UserInfoDto;
import com.titxu.core.pojo.dto.UserInfoDtoRequest;
import com.titxu.core.pojo.entity.UserInfo;
import com.titxu.core.pojo.vo.UserInfoRegisterVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserInfoConvert {
    UserInfoDto toRequestDto(UserInfoDtoRequest request);

    UserInfoDto toDto(UserInfo entity);

    UserInfoRegisterVo toRegisterVo(UserInfoDto dto);

    UserInfo toEntity(UserInfoDto toDto);
}

