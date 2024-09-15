package com.yyds.yaman.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MemberStatisticsVO {

    @ApiModelProperty("年龄或地区")
    private String title;

    @ApiModelProperty("人数")
    private Integer value;
}
