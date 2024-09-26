package com.yyds.yaman.pojo.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MryMemberExportVO {

    @ApiModelProperty("手机号")
    @Excel(name = "手机号")
    private String phone;


    @ApiModelProperty("会员号")
    @Excel(name = "会员号")
    private String vipNumber;


    @ApiModelProperty("用户名")
    @Excel(name = "用户名")
    private String userName;


    @Excel(name = "设备状态")
    private String deviceStatus;

    @ApiModelProperty("设备序列号")
    @Excel(name = "设备序列号")
    private String sn;

    @ApiModelProperty("所属产品型号")
    @Excel(name = "所属产品型号")
    private String productMode;

    @ApiModelProperty("产品名称")
    @Excel(name = "产品名称")
    private String productName;

    @Excel(name = "备注")
    @ApiModelProperty("备注")
    private String remark;


}
