package com.ruoyi.common.core.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SysUserEditParam {
    @ApiModelProperty(value = "id", required = true, position = 1)
    @NotNull(message = "id不能为空")
    private Long userId;

    @NotBlank(message = "账号名不能为空")
    @ApiModelProperty(value = "账号名", required = true)
    private String userName;

//    @NotBlank(message = "登录密码不能为空")
//    @ApiModelProperty(value = "登录密码", required = true)
//    private String password;

    @NotBlank(message = "员工姓名不能为空")
    @ApiModelProperty(value = "用户名称", required = true)
    private String nickName;

    @NotNull(message = "请选择用户角色")
    @ApiModelProperty(value = "角色ID", required = true)
    private Long roleId;

    @ApiModelProperty(value = "手机号码")
    private String phone;


}
