package com.ruoyi.common.core.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class SysRoleEditBody {
    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    /** 角色名称 */
    @ApiModelProperty(value = "角色名称")
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    @ApiModelProperty(value = "菜单ID（包括菜单和按钮）")
    @NotEmpty(message = "菜单不能为空")
    private Long[] menuIds;

}
