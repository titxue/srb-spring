package com.titxu.base.pojo.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Platform {
    Ali(0,"阿里云"),
    Tencent(1,"腾讯云");

    private final int code;
    private final String codeDesc;
}

