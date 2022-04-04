package com.titxu.storage.pojo.vo;

import lombok.Data;

@Data
public class FileUploadVo {
    private String fileId;

    private String secretId;

    private String secretKey;

    private String sessionToken;

    private String key;

    private String bucket;

    private String region;

    private String expiration;
}