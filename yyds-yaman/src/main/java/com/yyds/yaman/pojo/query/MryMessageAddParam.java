package com.yyds.yaman.pojo.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 * 消息查询 对象
 *
 * @author zzy
 */
@ApiModel(description="消息查询对象")
@Data
public class MryMessageAddParam {
    @ApiModelProperty("消息标题")
    @NotBlank(message = "消息标题不能为空")
    @Max(value = 30, message = "消息标题长度不能超过30")
    private String msgTitle;

    @NotBlank(message = "消息内容不能为空")
    @Max(value = 300, message = "消息内容长度不能超过300")
    @ApiModelProperty("消息内容")
    private String msgContent;

    @ApiModelProperty("地区编号,多个中间用逗号隔开")
    private String areaCodes;

    @ApiModelProperty("地区名称, 多个中间用逗号隔开")
    private String areaName;

}
