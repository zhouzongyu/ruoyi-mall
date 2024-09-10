package com.ruoyi.common.core.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysMenuVo {

    /** 菜单ID */
    @ApiModelProperty(value = "菜单ID")
    private Long menuId;

    /** 菜单名称 */
    @ApiModelProperty(value = "菜单名称")
    private String menuName;


}
