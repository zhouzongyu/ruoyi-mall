package com.ruoyi.common.core.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录对象
 * 
 * @author ruoyi
 */
@Data
public class LoginBody
{
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 用户密码
     */
    @NotBlank(message = "用户密码不能为空")
    @ApiModelProperty(value = "用户密码,MD5加密")
    private String password;
//
//    /**
//     * 验证码
//     */
//    private String code;
//
//    /**
//     * 唯一标识
//     */
//    private String uuid = "";
}
