package com.ruoyi.common.core.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class SysUserEditParam {
    @ApiModelProperty(value = "id", required = true, position = 1)
    @NotNull(message = "id不能为空")
    private Long userId;

    @NotBlank(message = "账号名不能为空")
    @Size(min =4, max = 16, message = "账号名长度在4-16位之间")
    @ApiModelProperty(value = "账号名", required = true)
    private String userName;

    @NotBlank(message = "员工姓名不能为空")
    @Size(max = 20, message = "员工姓名长度不能超过20")
    @ApiModelProperty(value = "用户名称", required = true)
    private String nickName;

    @NotNull(message = "请选择用户角色")
    @ApiModelProperty(value = "角色ID", required = true)
    private Long roleId;

    @ApiModelProperty(value = "手机号码")
    private String phone;


}
