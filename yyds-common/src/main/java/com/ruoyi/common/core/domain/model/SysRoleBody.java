package com.ruoyi.common.core.domain.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class SysRoleBody {
    private Long roleId;

    /** 角色名称 */
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    @NotEmpty(message = "菜单不能为空")
    private Long[] menuIds;

}
