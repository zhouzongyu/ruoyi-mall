package com.yyds.yaman.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MryMemberDeviceVo {
    @ApiModelProperty("用户ID" )
    private String deviceId;

    @ApiModelProperty("设备序号" )
    private String sn;

    @ApiModelProperty("产品名称" )
    private String productName;

    @ApiModelProperty("产品型号" )
    private String productMode;
}
