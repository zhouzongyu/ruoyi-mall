package com.yyds.yaman.pojo.vo;

import java.time.LocalDateTime;

import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Integer id;
    /**
     * 消息标题
     */
    @Excel(name = "消息标题")
    private String msgTitle;
    /**
     * 消息内容
     */
    @Excel(name = "消息内容")
    private String msgContent;
    /**
     * 消息状态  1-已发布 0-待发布
     */
    @Excel(name = "消息状态  1-已发布 0-待发布")
    private Integer msgStatus;
    /**
     * 接收消息区域
     */
    @Excel(name = "接收消息区域")
    private String areas;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishTime;
    /**
     * 删除标识
     */
    @Excel(name = "删除标识")
    private Integer deleteFlag;
}
