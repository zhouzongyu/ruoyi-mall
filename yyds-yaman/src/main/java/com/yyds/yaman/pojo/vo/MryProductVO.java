package com.yyds.yaman.pojo.vo;


import java.time.LocalDateTime;
import java.util.List;

import com.ruoyi.common.annotation.Excel;

import com.yyds.yaman.pojo.query.MryProductUsageFunctionEditParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 产品管理 数据视图对象
 *
 * @author zzy
 */
@Data
public class MryProductVO {
    /**
     * 产品ID
     */
    @ApiModelProperty(value = "产品ID")
    private String id;
    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String name;
    /**
     * 产品类型
     */
    @ApiModelProperty(value = "产品类型 1-美容仪")
    private Integer type;
    /**
     * 产品型号
     */
    @ApiModelProperty(value = "产品型号")
    private String model;

    /**
     * 主图
     */
    @Excel(name = "主图")
    private String picUrl;
    /**
     * 发布时间
     */
    @ApiModelProperty(value = "发布时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

}