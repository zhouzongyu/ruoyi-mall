package com.ruoyi.common.core.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class SysUserInfoVo {
    @ApiModelProperty(value = "用户Id")
    private Long userId;

    @ApiModelProperty(value = "账号名")
    private String userName;


    @NotBlank(message = "用户名称不能为空")
    @ApiModelProperty(value = "用户名称")
    private String nickName;


    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "权限列表，如system:user:list, 前端使用例子：v-hasPermi=\"['system:user:list']\"")
    private Set<String> permissions;


}
