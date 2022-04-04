package com.titxu.storage.pojo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * entity 基类
 *
 * @author lxue
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -8238597441668608529L;

    private Long id;

    private int deleted;
    private String createBy;


    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    private String updateBy;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    private String remark;



}