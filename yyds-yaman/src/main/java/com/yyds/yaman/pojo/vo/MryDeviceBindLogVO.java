package com.yyds.yaman.pojo.vo;

import java.time.LocalDateTime;

import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 设备绑定记录 数据视图对象
 *
 * @author zzy
 */
@Data
public class MryDeviceBindLogVO {
    @ApiModelProperty("日志ID" )
    private Long id;


    @ApiModelProperty("1：绑定  2：解绑" )
    @Excel(name = "1：绑定  2：解绑" )
    private Integer action;


    @ApiModelProperty("操作用户" )
    @Excel(name = "操作用户" )
    private String userName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @ApiModelProperty("操作时间" )
    private LocalDateTime createTime;
}
