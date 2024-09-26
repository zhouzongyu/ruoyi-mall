package com.yyds.yaman.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @ApiModelProperty("说明记录ID，新增的话值为空, 否则不能为空")
    private String id;

    @ApiModelProperty("内容")
    @Excel(name = "内容")
    private String content;

    @ApiModelProperty("标题")
    @Excel(name = "标题")
    private String title;

    @ApiModelProperty("主图")
    private String picUrl;

    @ApiModelProperty("产品Id")
    @Excel(name = "产品Id")
    private String productId;

    @ApiModelProperty("1-使用方法 2-功能介绍")
    @Excel(name = "1-使用方法 2-功能介绍")
    private Integer type;

}
