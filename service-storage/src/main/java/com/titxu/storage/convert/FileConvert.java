package com.titxu.storage.convert;

import com.titxu.storage.pojo.dto.FileDTO;
import com.titxu.storage.pojo.dto.FileUploadRequest;
import com.titxu.storage.pojo.entity.File;
import com.titxu.storage.pojo.vo.FileVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileConvert {
    File createEntity(FileUploadRequest fileUploadRequest);

    FileVo toVO(FileDTO fileDTO);

    FileDTO toDto(File file);
}