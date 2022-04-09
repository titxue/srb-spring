package com.titxu.core.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <p>
 * 用户基本信息
 * </p>
 *
 * @author Lxue
 * @since 2022-03-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserInfo对象", description="用户基本信息")
public class UserInfoDtoRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "1：出借人 2：借款人")
    private Integer userType;

    @ApiModelProperty(value = "手机号")
    @NotNull(message = "手机号不能为空")
    @NotBlank(message = "手机号不能为空")
    @Size(min = 11, max = 11, message = "手机号必须是11位")
    private String mobile;

    @ApiModelProperty(value = "验证码")
    @NotNull(message = "验证码不能为空")
    @NotBlank(message = "验证码不能为空")
    @Size(min = 4, max = 4, message = "验证码必须是4位")
    private String code;

    @ApiModelProperty(value = "用户密码")
    @Size(min = 6, max = 16, message = "密码必须是6-16位")
    @NotBlank(message = "密码不能为空")
    @NotNull(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "用户昵称")
    @NotBlank(message = "昵称不能为空")
    @NotNull(message = "昵称不能为空")
    private String nickName;


}
