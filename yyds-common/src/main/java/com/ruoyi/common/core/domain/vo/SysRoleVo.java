package com.ruoyi.common.core.domain.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SysRoleVo {

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    /** 角色名称 */
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "权限菜单列表")
    private List<SysMenuVo> meuns;


}
