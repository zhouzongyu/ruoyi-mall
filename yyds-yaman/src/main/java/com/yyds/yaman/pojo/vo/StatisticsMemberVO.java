package com.yyds.yaman.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StatisticsMemberVO {

    @ApiModelProperty("年龄或地区")
    private String name;

    @ApiModelProperty("人数")
    private Integer count;
}
