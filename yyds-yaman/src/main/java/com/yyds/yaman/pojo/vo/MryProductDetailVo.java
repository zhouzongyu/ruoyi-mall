package com.yyds.yaman.pojo.vo;


import com.ruoyi.common.annotation.Excel;
import com.yyds.yaman.pojo.query.MryProductUsageFunctionEditParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 产品管理 数据视图对象
 *
 * @author zzy
 */
@Data
public class MryProductDetailVo {
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
     * 通信方式
     */
    @ApiModelProperty(value = "通信方式")
    private Integer communication;
    /**
     * 配网方式
     */
    @ApiModelProperty(value = "配网方式")
    private Integer networking;
    /**
     * 档位（多选）
     */
    @ApiModelProperty(value = "档位")
    private String gear;
    /**
     * 产品功能（多选）
     */
    @ApiModelProperty(value = "产品功能")
    private String functionType;
    /**
     * 规格参数
     */
    @ApiModelProperty(value = "规格参数")
    private String spec;
    /**
     * 主图
     */
    @ApiModelProperty(value = "主图")
    private String picUrl;
    /**
     * 发布时间
     */
    @ApiModelProperty(value = "发布时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "使用方法", required = false)
    private List<MryProductUsageFunctionEditParam> usages;

    @ApiModelProperty(value = "功能说明", required = false)
    private List<MryProductUsageFunctionEditParam> functions;
}
