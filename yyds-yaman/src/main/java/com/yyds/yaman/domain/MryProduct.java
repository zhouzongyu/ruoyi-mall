package com.yyds.yaman.domain;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 产品管理对象 mry_product
 * 
 * @author zzy
 */
@ApiModel(description="产品管理对象")
@Data
@TableName("mry_product")
public class MryProduct {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("产品ID")
    private String id;

    @ApiModelProperty("产品名称")
    @Excel(name = "产品名称")
    private String name;

    @ApiModelProperty("产品类型")
    @Excel(name = "产品类型")
    private Integer type;

    @ApiModelProperty("产品型号")
    @Excel(name = "产品型号")
    private Integer model;

    @ApiModelProperty("通信方式")
    @Excel(name = "通信方式")
    private Integer communication;

    @ApiModelProperty("配网方式")
    @Excel(name = "配网方式")
    private Integer networking;

    @ApiModelProperty("档位（多选）")
    @Excel(name = "档位", readConverterExp = "多=选")
    private String gear;

    @ApiModelProperty("产品功能（多选）")
    @Excel(name = "产品功能", readConverterExp = "多=选")
    private String function;

    @ApiModelProperty("规格参数")
    @Excel(name = "规格参数")
    private String spec;

    @ApiModelProperty("主图")
    @Excel(name = "主图")
    private String picUrl;

    @ApiModelProperty(" 发布时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("删除标识")
    @Excel(name = "删除标识")
    private Integer deleteFlag;

}
