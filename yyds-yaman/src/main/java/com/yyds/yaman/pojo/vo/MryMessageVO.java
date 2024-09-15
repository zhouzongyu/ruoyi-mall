package com.yyds.yaman.pojo.vo;

import java.time.LocalDateTime;

import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 消息数据视图对象
 *
 * @author zzy
 */
@Data
public class MryMessageVO {
    /**
     * ID
     */
    @ApiModelProperty("消息ID")
    private Integer id;
    /**
     * 消息标题
     */
    @ApiModelProperty("消息标题")
    private String msgTitle;
    /**
     * 消息内容
     */
    @ApiModelProperty(name = "消息内容")
    private String msgContent;
    /**
     * 消息状态  1-已发布 0-待发布
     */
    @ApiModelProperty(name = "消息状态  1-已发布 0-待发布")
    private Integer msgStatus;
    /**
     * 接收消息区域
     */
    @ApiModelProperty(name = "接收消息区域编号")
    private String areaCodes;

    @ApiModelProperty(name = "接收消息区域名称")
    private String areaNames;
    /**
     * 创建时间
     */
    @ApiModelProperty(name = "创建时间")
    private LocalDateTime createTime;
    /**
     * 发布时间
     */
    @ApiModelProperty(name = "发布时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishTime;
}
