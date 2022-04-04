package com.titxu.storage.pojo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum FileType {
    AUDIO(0,"音频"),
    IMAGE(1,"图片"),
    VIDEO(2,"视频"),
    OTHER(3,"其他");

    @EnumValue
    private int code;
    private String codeDesc;
}