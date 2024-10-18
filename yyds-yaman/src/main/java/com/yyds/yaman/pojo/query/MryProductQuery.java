package com.yyds.yaman.pojo.query;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 产品管理 查询 对象
 *
 * @author zzy
 */
@ApiModel(description="产品管理 查询 对象")
@Data
public class MryProductQuery {
    @ApiModelProperty("产品名称")
    private String name;

    @ApiModelProperty("产品类型")
    private Integer type;

    @ApiModelProperty("产品型号")
    private String model;

    /**
     * 排序的列字段
     */
    private String column;

    /**
     * 排序规则默认降序 降序:false 升序:true
     */
    private Boolean asc;

    public Boolean getAsc() {
        return asc == null ? false : asc;
    }

}
