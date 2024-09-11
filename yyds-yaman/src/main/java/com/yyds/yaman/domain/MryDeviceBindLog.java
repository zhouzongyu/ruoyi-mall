package com.yyds.yaman.domain;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 设备绑定记录对象 mry_device_bind_log
 * 
 * @author zzy
 */
@ApiModel(description="设备绑定记录对象")
@Data
@TableName("mry_device_bind_log")
public class MryDeviceBindLog {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("设备ID")
    @Excel(name = "设备ID")
    private String deviceId;

    @ApiModelProperty("1：绑定  2：解绑")
    @Excel(name = "1：绑定  2：解绑")
    private Integer action;

    @ApiModelProperty("用户编号")
    @Excel(name = "用户编号")
    private String userId;

    @ApiModelProperty("用户名称")
    @Excel(name = "用户名称")
    private String userName;

    @ApiModelProperty("操作时间")
    private LocalDateTime createTime;

}
