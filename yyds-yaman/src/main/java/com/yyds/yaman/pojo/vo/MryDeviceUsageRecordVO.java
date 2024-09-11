package com.yyds.yaman.pojo.vo;

import java.time.LocalDateTime;

import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 设备使用记录 数据视图对象
 *
 * @author zzy
 */
@Data
public class MryDeviceUsageRecordVO {
    /**
     * ID
     */
    private Long id;

    /**
     * 使用时间
     */
    @ApiModelProperty("使用时间" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @Excel(name = "使用时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss" )
    private LocalDateTime usageTime;

    @ApiModelProperty("时长" )
    private Integer duration;
    /**
     * 模式
     */
    @ApiModelProperty("美容模式" )
    private String mode;
    /**
     * 档位
     */
    @Excel(name = "档位" )
    private String gear;
}
