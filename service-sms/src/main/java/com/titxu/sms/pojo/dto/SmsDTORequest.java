package com.titxu.sms.pojo.dto;

import com.titxu.sms.pojo.enums.Platform;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.RegEx;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class SmsDTORequest {
    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "手机号不能为空")
    @NotNull(message = "手机号不能为空")
    @Size(min = 11, max = 11, message = "手机号只能为11位")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String phone;


}
