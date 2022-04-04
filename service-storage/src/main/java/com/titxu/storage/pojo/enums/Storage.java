package com.titxu.storage.pojo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;



@AllArgsConstructor
@Getter
public enum Storage {
    OSS(0,"阿里云"),
    COS(1,"腾讯云");

    @EnumValue
    private int code;
    private String codeDesc;
}