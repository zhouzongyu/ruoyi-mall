package com.yyds.yaman.domain;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 产品使用方法和功能说明对象 mry_product_usage_functions
 * 
 * @author zzy
 */
@ApiModel(description="产品使用方法和功能说明对象")
@Data
@TableName("mry_product_usage_functions")
public class MryProductUsageFunctions {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("内容")
    @Excel(name = "内容")
    private String content;

    @ApiModelProperty("标题")
    @Excel(name = "标题")
    private String title;

    @ApiModelProperty("主图")
    @Excel(name = "PICS")
    private String pics;

    @ApiModelProperty("产品Id")
    @Excel(name = "产品Id")
    private String productId;

    @ApiModelProperty("1-使用方法 2-功能介绍")
    @Excel(name = "1-使用方法 2-功能介绍")
    private Integer type;

}