package com.ruoyi.common.core.domain.vo;

import com.ruoyi.common.core.domain.TreeSelect;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
@Data
public class SysRoleMenuVo {
    @ApiModelProperty(value = "角色授权菜单ID数组")
    private List<Integer> checkedKeys;

    @ApiModelProperty(value = "功能菜单列表")
    private List<TreeSelect> menus;
}
