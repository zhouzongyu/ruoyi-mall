package com.ruoyi.common.core.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class SysRoleAddBody {

    /** 角色名称 */
    @ApiModelProperty(value = "角色名称")
    @NotBlank(message = "角色名称不能为空")
    @Size(min = 2, max = 30, message = "角色名称长度在2-30位之间")
    private String roleName;

    @ApiModelProperty(value = "菜单ID（包括菜单和按钮）")
    @NotEmpty(message = "菜单不能为空")
    private List<Long> menuIds;

}
