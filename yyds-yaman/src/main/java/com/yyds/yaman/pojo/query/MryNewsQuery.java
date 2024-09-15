package com.yyds.yaman.pojo.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 资讯文章 查询 对象
 *
 * @author zzy
 */
@ApiModel(description="资讯文章")
@Data
public class MryNewsQuery {
    @ApiModelProperty(value = "标题", required = false)
    private String title;

    @ApiModelProperty(name = "startTime", value = "开始时间,格式:yyyy-MM-dd", required = false, dataType = "String")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String startTime;

    @ApiModelProperty(name = "endTime", value = "结束时间,格式:yyyy-MM-dd", required = false, dataType = "String")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String endTime;
}
