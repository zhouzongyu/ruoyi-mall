package com.ruoyi.common.core.domain.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysDictDataVo {
    /** 字典编码 */
    @ApiModelProperty(value = "字典编码")
    private Long dictCode;


    /** 字典标签 */
    @ApiModelProperty(value = "字典键名")
    private String dictLabel;

    /** 字典键值 */
    @ApiModelProperty(value = "字典键值")
    private String dictValue;

    /** 字典类型 */
    @ApiModelProperty(value = "字典类型")
    private String dictType;


}
