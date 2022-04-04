package com.titxu.storage.pojo.entity;


import com.titxu.storage.pojo.enums.FileStatus;
import com.titxu.storage.pojo.enums.FileType;
import com.titxu.storage.pojo.enums.Storage;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class File extends BaseEntity{
    private static final long serialVersionUID = 2254569544818428525L;

    private Long id;

    private String name;

    private String fileKey;


    // 扩展名
    private String ext;

    private Integer size;


    private FileType type;


    private Storage storage;


    private FileStatus status = FileStatus.UPLOADING;


}
