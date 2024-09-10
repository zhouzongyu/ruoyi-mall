package com.yyds.yaman.pojo.vo;


import java.time.LocalDateTime;

import com.ruoyi.common.annotation.Excel;

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
    private String id;
    /**
     * 产品名称
     */
    @Excel(name = "产品名称")
    private String name;
    /**
     * 产品类型
     */
    @Excel(name = "产品类型")
    private Integer type;
    /**
     * 产品型号
     */
    @Excel(name = "产品型号")
    private Integer model;
    /**
     * 通信方式
     */
    @Excel(name = "通信方式")
    private Integer communication;
    /**
     * 配网方式
     */
    private Integer networking;
    /**
     * 档位（多选）
     */
    @Excel(name = "档位", readConverterExp = "多=选")
    private String gear;
    /**
     * 产品功能（多选）
     */
    @Excel(name = "产品功能", readConverterExp = "多=选")
    private String function;
    /**
     * 规格参数
     */
    @Excel(name = "规格参数")
    private String spec;
    /**
     * 主图
     */
    @Excel(name = "主图")
    private String picUrl;
    /**
     * 发布时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 删除标识
     */
    @Excel(name = "删除标识")
    private Integer deleteFlag;
}
