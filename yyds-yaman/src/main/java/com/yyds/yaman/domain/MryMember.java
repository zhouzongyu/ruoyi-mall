package com.yyds.yaman.domain;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 会员对象 mry_member
 * 
 * @author zzy
 */
@ApiModel(description="会员对象")
@Data
@TableName("mry_member")
public class MryMember {
    private static final long serialVersionUID = 1L;

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

    @ApiModelProperty("性别")
    @Excel(name = "性别")
    private Integer gender;

    @ApiModelProperty("居住地区")
    @Excel(name = "居住地区")
    private String address;

    @ApiModelProperty("用户肤质")
    @Excel(name = "用户肤质")
    private Integer skinType;

    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String remark;

    @ApiModelProperty("公众号openId")
    @Excel(name = "公众号openId")
    private String openId;

    @ApiModelProperty("小程序openId")
    @Excel(name = "小程序openId")
    private String miniProgramOpenId;

    @ApiModelProperty("unionid")
    @Excel(name = "unionid")
    private String unionId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    private Integer deleteFlag;

}
