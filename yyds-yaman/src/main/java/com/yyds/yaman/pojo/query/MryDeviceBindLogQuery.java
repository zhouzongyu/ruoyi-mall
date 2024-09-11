package com.yyds.yaman.pojo.query;

import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 设备绑定记录 查询 对象
 *
 * @author zzy
 */
@ApiModel(description="设备绑定记录 查询 对象")
@Data
public class MryDeviceBindLogQuery {
    @ApiModelProperty("设备ID 精确匹配")
    private String deviceId;

    @ApiModelProperty("1：绑定  2：解绑 精确匹配")
    private Integer action;

    @ApiModelProperty("用户编号 精确匹配")
    private String userId;

    @ApiModelProperty("用户名称 精确匹配")
    private String userNameLike;

}
