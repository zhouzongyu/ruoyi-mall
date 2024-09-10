package com.ruoyi.common.core.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SysUserVo {

    private static final long serialVersionUID = 1L;


    private Long userId;

    @NotBlank(message = "账号名不能为空")
    @ApiModelProperty(value = "账号名")
    private String userName;

//    @ApiModelProperty(value = "登录密码")
//    private String password;

    @NotBlank(message = "用户名称不能为空")
    @ApiModelProperty(value = "用户名称")
    private String nickName;


    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "手机号码")
    private String phone;

}
