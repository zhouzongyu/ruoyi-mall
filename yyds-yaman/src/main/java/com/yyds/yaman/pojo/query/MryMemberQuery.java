package com.yyds.yaman.pojo.query;

import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员 查询 对象
 *
 * @author zzy
 */
@ApiModel(description="会员 查询 对象")
@Data
public class MryMemberQuery {
    @ApiModelProperty("用户名 精确匹配")
    private String userNameLike;

    @ApiModelProperty("手机号 精确匹配")
    private String phone;

    @ApiModelProperty("会员号 精确匹配")
    private String vipNumber;

    @ApiModelProperty("出生日期 精确匹配")
    private String birthDate;

    @ApiModelProperty("性别 精确匹配")
    private Integer gender;

    @ApiModelProperty("居住地区 精确匹配")
    private String address;

    @ApiModelProperty("用户肤质 精确匹配")
    private Integer skinType;

    @ApiModelProperty("公众号openId 精确匹配")
    private String openId;

    @ApiModelProperty("小程序openId 精确匹配")
    private String miniProgramOpenId;

    @ApiModelProperty("unionid 精确匹配")
    private String unionId;

}
