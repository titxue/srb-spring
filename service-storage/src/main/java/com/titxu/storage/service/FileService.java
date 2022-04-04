package com.titxu.storage.service;

import com.titxu.storage.pojo.dto.FileDTO;
import com.titxu.storage.pojo.dto.FileUploadDto;
import com.titxu.storage.pojo.dto.FileUploadRequest;

public interface FileService {
    FileUploadDto getSignature(FileUploadRequest fileUploadRequest);

    FileDTO finish(Long id);

    FileDTO delete(Long id);
}
