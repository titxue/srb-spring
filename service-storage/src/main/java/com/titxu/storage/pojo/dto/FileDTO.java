package com.titxu.storage.pojo.dto;

import com.titxu.storage.pojo.enums.FileStatus;
import com.titxu.storage.pojo.enums.FileType;
import com.titxu.storage.pojo.enums.Storage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FileDTO {
    private String id;

    private String name;

    private String fileKey;

    private String ext;

    private Integer size;

    private FileType type;

    private Storage storage;

    private FileStatus status;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;
}