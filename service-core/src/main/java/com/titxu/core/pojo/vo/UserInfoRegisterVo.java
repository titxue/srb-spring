package com.titxu.core.pojo.vo;

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
public class UserInfoRegisterVo implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "1：出借人 2：借款人")
    private Integer userType;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "头像")
    private String headImg;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


}
