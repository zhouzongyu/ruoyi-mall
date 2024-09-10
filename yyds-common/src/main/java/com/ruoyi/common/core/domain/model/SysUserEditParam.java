package com.ruoyi.common.core.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SysUserEditParam {
    @ApiModelProperty(value = "id", required = true, position = 1)
    @NotNull(message = "id不能为空")

    private Long id;

    @NotBlank(message = "账号名不能为空")
    @ApiModelProperty(value = "账号名")
    private String userName;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "用户名称")
    private String nickName;


    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "手机号码")
    private String phone;


}
