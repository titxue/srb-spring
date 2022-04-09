package com.titxu.core.pojo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class UserInfoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    private Long id;

    @ApiModelProperty(value = "1：出借人 2：借款人")
    private Integer userType;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "身份证号")
    private String idCard;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "微信用户标识openid")
    private String openid;

    @ApiModelProperty(value = "头像")
    private String headImg;

    @ApiModelProperty(value = "绑定状态（0：未绑定，1：绑定成功 -1：绑定失败）")
    private Integer bindStatus;

    @ApiModelProperty(value = "借款人认证状态（0：未认证 1：认证中 2：认证通过 -1：认证失败）")
    private Integer borrowAuthStatus;

    @ApiModelProperty(value = "绑定账户协议号")
    private String bindCode;

    @ApiModelProperty(value = "用户积分")
    private Integer integral;

    @ApiModelProperty(value = "状态（0：锁定 1：正常）")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;



}