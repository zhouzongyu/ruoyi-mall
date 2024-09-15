package com.yyds.yaman.domain;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 消息对象 mry_message
 * 
 * @author zzy
 */
@ApiModel(description="消息对象")
@Data
@TableName("mry_message")
public class MryMessage {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("消息标题")
    @Excel(name = "消息标题")
    private String msgTitle;

    @ApiModelProperty("消息内容")
    @Excel(name = "消息内容")
    private String msgContent;

    @ApiModelProperty("消息状态  1-已发布 0-待发布")
    @Excel(name = "消息状态  1-已发布 0-待发布")
    private Integer msgStatus;

    @ApiModelProperty("接收消息区域")
    @Excel(name = "接收消息区域")
    private String areaCodes;

    @ApiModelProperty("接收消息区域")
    @Excel(name = "接收消息区域")
    private String areaNames;


    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("发布时间")
    private LocalDateTime publishTime;

    @ApiModelProperty("删除标识")
    @Excel(name = "删除标识")
    private Integer deleteFlag;

}
