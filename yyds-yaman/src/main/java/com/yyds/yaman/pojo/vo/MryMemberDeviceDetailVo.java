package com.yyds.yaman.pojo.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MryMemberDeviceDetailVo {
    @ApiModelProperty("用户ID" )
    private String deviceId;

    @ApiModelProperty("设备序号" )
    private String sn;

    @ApiModelProperty("产品名称" )
    private String productName;

    @ApiModelProperty("产品型号" )
    private String productMode;

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
     * 通信方式
     */
    @ApiModelProperty(value = "通信方式")
    private Integer communication;
    /**
     * 配网方式
     */
    @ApiModelProperty(value = "配网方式")
    private Integer networking;



}
