package com.titxu.storage.pojo.dto;

import lombok.Data;

@Data
public class FileUploadDto {

    private Long fileId;

    private String secretId;

    private String secretKey;

    private String sessionToken;

    private String fileKey;

    private String bucket;

    private String region;

    private String requestId;

    private Long expiration;


}