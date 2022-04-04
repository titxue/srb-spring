package com.titxu.storage.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel(value = "BaseDto", description = "基础Dto")
public class BaseDto implements Serializable {

    private static final long serialVersionUID = 5313005184377443380L;
    @ApiModelProperty(value  = "标签ID")
    private Long id;

    private int deleted;

    @ApiModelProperty(value  = "创建者")
    private String createBy;


    @ApiModelProperty(value  = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;


    @ApiModelProperty(value  = "更新者")
    private String updateBy;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value  = "更新时间")
    private LocalDateTime updateTime;


    @ApiModelProperty(value  = "备注")
    private String remark;
}
