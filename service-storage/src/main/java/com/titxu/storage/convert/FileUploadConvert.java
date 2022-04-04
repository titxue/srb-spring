package com.titxu.storage.convert;

import com.titxu.storage.pojo.dto.FileUploadDto;
import com.titxu.storage.pojo.vo.FileUploadVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileUploadConvert {
    FileUploadVo toVO(FileUploadDto fileUploadDto);
}