package com.ruoyi.common.core.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SysUserAddParam {



    @NotBlank(message = "账号名不能为空")
    @Max(value = 16, message = "账号长度不能超过16位")
    @Min(value = 4, message = "账号长度不能少于4位")
    @ApiModelProperty(value = "账号名", required = true)
    private String userName;

    @NotBlank(message = "员工姓名不能为空")
    @Max(value = 20, message = "员工姓名长度不能超过20")
    @ApiModelProperty(value = "用户名称", required = true)
    private String nickName;

    @NotBlank(message = "登录密码不能为空")
    @ApiModelProperty(value = "登录密码", required = true)
    private String password;



    @NotNull(message = "请选择用户角色")
    @ApiModelProperty(value = "角色ID", required = true)
    private Long roleId;

    @ApiModelProperty(value = "手机号码")
    private String phone;


}
