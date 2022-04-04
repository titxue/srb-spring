package com.titxu.storage.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class BaseVo {

    @ApiModelProperty(value  = "创建时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value  = "更新时间")
    private LocalDateTime updateTime;
}
