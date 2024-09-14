package com.yyds.yaman.pojo.query;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 消息查询 对象
 *
 * @author zzy
 */
@ApiModel(description="消息查询对象")
@Data
public class MryMessageQuery {
    @ApiModelProperty("消息标题")
    private String msgTitle;

    @ApiModelProperty("消息内容 精确匹配")
    private String msgContent;

    @ApiModelProperty(name = "startTime", value = "开始时间", required = false, dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startTime;

    @ApiModelProperty(name = "endTime", value = "结束时间", required = false, dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endTime;

}
