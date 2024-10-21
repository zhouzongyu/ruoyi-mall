package com.yyds.yaman.pojo.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class MryMemberDetailVo {
    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("用户名")
    @Excel(name = "用户名")
    private String userName;

    @ApiModelProperty("手机号")
    @Excel(name = "手机号")
    private String phone;

    @ApiModelProperty("会员号")
    @Excel(name = "会员号")
    private String vipNumber;

    @ApiModelProperty("出生日期")
    @Excel(name = "出生日期")
    private String birthDate;

    @ApiModelProperty("性别 1-男 2-女")
    @Excel(name = "性别")
    private Integer gender;

    @ApiModelProperty("居住地区")
    @Excel(name = "居住地区")
    private String address;

    @ApiModelProperty("用户肤质 1-油性肌肤 2-混合性肌肤 3-中性肌肤 4-干性肌肤 5-敏感性肌肤 6-混干肌肤 ")
    @Excel(name = "用户肤质")
    private Integer skinType;

    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String remark;

    @ApiModelProperty("设备列表" )
    private List<MryMemberDeviceDetailVo> devices;
}
