package com.titxu.storage.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FileUploadRequest {

    @NotBlank(message = "文件名不能为空")
    private String name;

    private Integer size;

    @NotBlank(message = "后缀名不能为空")
    private String ext;

    @NotBlank(message = "fileKey不能为空")
    private String fileKey;
}