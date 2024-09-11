package com.yyds.yaman.pojo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 产品管理 查询 对象
 *
 * @author zzy
 */
@ApiModel(description="产品管理")
@Data
public class MryProductEditParam {
    @ApiModelProperty(value = "产品ID",required = true)
    private String id;

    @ApiModelProperty(value = "产品名称",required = true)
    private String name;

    @ApiModelProperty(value = "产品类型 1-美容仪",required = true)
    private Integer type;

    @ApiModelProperty(value = "产品型号",required = true)
    private String model;

    @ApiModelProperty(value = "通信方式",required = true)
    private Integer communication;

    @ApiModelProperty(value = "配网方式",required = true)
    private Integer networking;

    @ApiModelProperty("档位（ 多个中间用逗号隔开）")
    private String gear;

    @ApiModelProperty("产品功能（ 多个中间用逗号隔开）")
    private String function;

    @ApiModelProperty("规格参数")
    private String spec;

    @ApiModelProperty(value = "主图", required = true)
    private String picUrl;

    @ApiModelProperty(value = "使用方法", required = false)
    private List<MryProductUsageFunctionEditParam> usages;

    @ApiModelProperty(value = "功能说明", required = false)
    private List<MryProductUsageFunctionEditParam> functions;

}
