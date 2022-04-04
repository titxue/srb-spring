package com.titxu.storage.pojo.enums;


import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FileStatus {
    UPLOADING(0, "正在上传"),
    UPLOADED(1, "上传完毕"),
    CANCEL(2, "取消");

    @EnumValue
    private int code;
    private String codeDesc;
}