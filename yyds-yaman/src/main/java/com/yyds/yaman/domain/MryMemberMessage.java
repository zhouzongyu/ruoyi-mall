package com.yyds.yaman.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
@Data
@TableName("mry_member_message")
public class MryMemberMessage {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    private String userId;

    /**
     * 消息标题
     */
    private String msgTitle;

    /**
     * 消息内容
     */
    private String msgContent;

    /**
     * 消息状态  0-未读  1-已读
     */
    private String msgStatus;


    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 推送模板消息状态  1-发送成功 2-发送失败 0-待发送
     */
    private String sendStatus;
    /**
     * 发布时间
     */
    private Date sendTime;
    /**
     * 删除标识
     */
    private Integer deleteFlag;

    /**
     * 是否置顶
     */
    private String isTop;
}
