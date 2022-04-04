package com.titxu.storage.pojo.vo;

import com.titxu.storage.pojo.enums.FileStatus;
import com.titxu.storage.pojo.enums.FileType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FileVo extends BaseVo {
    private String name;

    private String fileKey;

    private String ext;

    private Integer size;

    private FileType type;

    private FileStatus status;
}