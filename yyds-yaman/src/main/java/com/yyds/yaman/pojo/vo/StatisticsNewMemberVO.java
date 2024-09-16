package com.yyds.yaman.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StatisticsNewMemberVO {

    @ApiModelProperty("日期")
    private String day;

    @ApiModelProperty("人数")
    private Integer count;
}
