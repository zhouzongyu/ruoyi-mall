package com.yyds.yaman.pojo.query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.utils.StringUtils;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 消息查询 对象
 *
 * @author zzy
 */
@Data
@ApiModel(description="消息查询对象")
public class MryMessageQuery {
    @ApiModelProperty("消息标题")
    private String msgTitle;

    @ApiModelProperty("消息内容 精确匹配")
    private String msgContent;

    /**
     * 开始时间
     */
    @ApiModelProperty(name = "startTime", value = "开始时间, 格式:yyyy-MM-dd", required = false, dataType = "String")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(name = "endTime", value = "结束时间, 格式:yyyy-MM-dd", required = false, dataType = "String")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String endTime;


}
