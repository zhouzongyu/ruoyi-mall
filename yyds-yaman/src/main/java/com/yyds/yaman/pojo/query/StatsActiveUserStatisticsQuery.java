package com.yyds.yaman.pojo.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StatsActiveUserStatisticsQuery {

    @NotNull(message = "统计类型不能为空")
    @ApiModelProperty("统计类型 1-按天（近一周） 2-按小时（近一天）")
    private Integer type;


    @ApiModelProperty("开始日期")
    private String beginTime;

    @ApiModelProperty("截止时间")
    private String endTime;
}
