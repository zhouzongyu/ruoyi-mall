package com.yyds.yaman.pojo.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * 消息查询 对象
 *
 * @author zzy
 */
@ApiModel(description="消息查询对象")
@Data
public class MryMessageEditParam {
    @ApiModelProperty("消息ID")
    private Integer id;

    @ApiModelProperty("消息标题")
    private String msgTitle;

    @ApiModelProperty("消息内容 精确匹配")
    private String msgContent;

    @ApiModelProperty("地区编号,多个中间用逗号隔开")
    private String areaCodes;

    @ApiModelProperty("地区名称, 多个中间用逗号隔开")
    private String areaName;
}
