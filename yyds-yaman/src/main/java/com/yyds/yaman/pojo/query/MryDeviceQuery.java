package com.yyds.yaman.pojo.query;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author zzy
 */
@ApiModel(description="设备查询对象")
@Data
public class MryDeviceQuery {
    @ApiModelProperty("设备编号")
    private String sn;

    @ApiModelProperty("设备型号")
    private String model;

    @ApiModelProperty("设备关联产品ID")
    private String productId;

    @ApiModelProperty("设备所在省份")
    private String usgeProvice;

    @ApiModelProperty("所在市区")
    private String usgeCity;

    @ApiModelProperty("所在地区")
    private String usgeArea;

}
