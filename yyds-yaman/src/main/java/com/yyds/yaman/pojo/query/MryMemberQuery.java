package com.yyds.yaman.pojo.query;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员 查询 对象
 *
 * @author zzy
 */
@ApiModel(description="会员对象")
@Data
public class MryMemberQuery {
    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("会员号")
    private String vipNumber;

    @ApiModelProperty("设备SN")
    private String deviceSn;

    @ApiModelProperty("产品型号")
    private String productMode;

    @ApiModelProperty("设备状态  1-已绑定 0-未绑定设备")
    private String deviceStatus;

}
