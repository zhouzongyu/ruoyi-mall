package com.yyds.yaman.pojo.query;

import java.time.LocalDateTime;
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
    @ApiModelProperty("产品名称 精确匹配")
    private String nameLike;

    @ApiModelProperty("产品类型 精确匹配")
    private Integer type;

    @ApiModelProperty("产品型号 精确匹配")
    private Integer model;

    @ApiModelProperty("通信方式 精确匹配")
    private Integer communication;

    @ApiModelProperty("配网方式 精确匹配")
    private Integer networking;

    @ApiModelProperty("档位（多选） 精确匹配")
    private String gear;

    @ApiModelProperty("产品功能（多选） 精确匹配")
    private String function;

    @ApiModelProperty("规格参数 精确匹配")
    private String spec;

    @ApiModelProperty("主图 精确匹配")
    private String picUrl;

    @ApiModelProperty("删除标识 精确匹配")
    private Integer delFlag;

}
