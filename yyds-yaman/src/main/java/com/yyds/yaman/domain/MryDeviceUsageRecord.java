package com.yyds.yaman.domain;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 设备使用记录对象 mry_device_usage_record
 * 
 * @author zzy
 */
@ApiModel(description="设备使用记录对象")
@Data
@TableName("mry_device_usage_record")
public class MryDeviceUsageRecord {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("用户id")
    @Excel(name = "用户id")
    private String userId;

    @ApiModelProperty("设备Id")
    @Excel(name = "设备Id")
    private String deviceId;

    @ApiModelProperty("使用时间")
    @Excel(name = "使用时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime usageTime;

    @ApiModelProperty("时长")
    @Excel(name = "时长")
    private Integer duration;

    @ApiModelProperty("模式")
    private String mode;

    @ApiModelProperty("档位")
    private String gear;

}
