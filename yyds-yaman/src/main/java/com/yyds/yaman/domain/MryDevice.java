package com.yyds.yaman.domain;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 *
 * @author zzy
 */
@ApiModel(description="设备实体类")
@Data
@TableName("mry_device")
public class MryDevice {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("设备ID")
    private String id;

    @ApiModelProperty("设备编号")
    @Excel(name = "设备编号")
    private String sn;

    @ApiModelProperty("设备型号")
    @Excel(name = "设备型号")
    private String model;

    @ApiModelProperty("设备关联产品ID")
    @Excel(name = "设备关联产品ID")
    private String productId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("设备所在省份")
    @Excel(name = "设备所在省份")
    private String usgeProvice;

    @ApiModelProperty("所在市区")
    @Excel(name = "所在市区")
    private String usgeCity;

    @ApiModelProperty("所在地区")
    @Excel(name = "所在地区")
    private String usgeArea;

}
