package com.titxu.base.pojo.dto;

import com.titxu.base.pojo.enums.Platform;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@ApiModel(value = "短信发送请求")
public class SmsDTORequest {
    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "手机号不能为空")
    @NotNull(message = "手机号不能为空")
    @Size(min = 11, max = 11, message = "手机号只能为11位")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String phone;

    @ApiModelProperty(value = "验证码")
    @NotBlank(message = "验证码不能为空")
    @NotNull(message = "验证码不能为空")
    @Size(min = 4, max = 6, message = "验证码长度为4-6位")
    private String code; //验证码

    @ApiModelProperty(value = "类型")
    private String type="register"; //register:注册 forgot:忘记密码

    @ApiModelProperty(value = "平台")
    @NotNull(message = "平台不能为空")
    private Platform platform; //平台




}
