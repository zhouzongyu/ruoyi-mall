package com.yyds.yaman.domain;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 用户设备关系对象 mry_member_device_relation
 * 
 * @author zzy
 */
@ApiModel(description="用户设备关系对象")
@Data
@TableName("mry_member_device_relation")
public class MryMemberDeviceRelation {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("用户Id")
    @Excel(name = "用户Id")
    private String userId;

    @ApiModelProperty("设备ID")
    @Excel(name = "设备ID")
    private String deviceId;

    @ApiModelProperty("绑定时间")
    @Excel(name = "绑定时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime bindTime;

}
