package com.yyds.yaman.pojo.query;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 产品使用方法和功能说明 查询 对象
 *
 * @author zzy
 */
@ApiModel(description="产品使用方法和功能说明")
@Data
public class MryProductUsageFunctionsQuery {
    @ApiModelProperty("内容 精确匹配")
    private String content;

    @ApiModelProperty("标题 精确匹配")
    private String title;

    @ApiModelProperty("PICS 精确匹配")
    private String pics;

    @ApiModelProperty("产品Id 精确匹配")
    private String productId;

    @ApiModelProperty("1-使用方法 2-功能介绍 精确匹配")
    private Integer type;

}
