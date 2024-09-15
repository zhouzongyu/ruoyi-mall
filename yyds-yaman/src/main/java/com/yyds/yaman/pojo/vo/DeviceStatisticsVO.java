package com.yyds.yaman.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DeviceStatisticsVO {

    @ApiModelProperty("设备总数")
    private Integer deviceCount;

    @ApiModelProperty("产品总数")
    private Integer productCount;


    @ApiModelProperty("已绑定设备总数")
    private Integer deviceBindCount;

    @ApiModelProperty("设备故障总数")
    private Integer deviceFaultCount;

}
