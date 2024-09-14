package com.yyds.yaman.pojo.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zzy
 */
@Data
public class MryDeviceVO {
    /**
     * 设备ID
     */
    @ApiModelProperty(name = "设备ID")
    private String id;
    /**
     * 设备编号
     */
    @ApiModelProperty(name = "设备编号")
    private String sn;
    /**
     * 设备型号
     */
    @ApiModelProperty(name = "设备型号")
    private String model;
    /**
     * 设备关联产品ID
     */
    @ApiModelProperty(name = "设备关联产品ID")
    private String productId;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 设备所在省份
     */
    @ApiModelProperty(name = "设备所在省份")
    private String usgeProvice;
    /**
     * 所在市区
     */
    @ApiModelProperty(name = "所在市区")
    private String usgeCity;
    /**
     * 所在地区
     */
    @ApiModelProperty(name = "所在地区")
    private String usgeArea;
}
