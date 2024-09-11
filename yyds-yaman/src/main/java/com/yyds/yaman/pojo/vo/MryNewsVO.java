package com.yyds.yaman.pojo.vo;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 资讯文章 数据视图对象
 * 
 * @author zzy
 */
@Data
public class MryNewsVO  {
   /** ID */
    private String id;
   /**  标题 */
    @Excel(name = " 标题")
    private String title;
   /** 正文 */
    @Excel(name = "正文")
    private String content;
   /** 排序 */
    @Excel(name = "排序")
    private Integer sortNo;
   /** 图片 */
    @Excel(name = "图片")
    private String picUrl;
   /** 视频 */
    @Excel(name = "视频")
    private String videoUrl;
   /** 创建时间 */
    private LocalDateTime createTime;
   /** 更新时间 */
    private LocalDateTime updateTime;
   /** 删除标识 */
    @Excel(name = "删除标识")
    private Integer deleteFlag;
   /** 阅读数 */
    @Excel(name = "阅读数")
    private Integer clickCount;
   /** 赞数 */
    @Excel(name = "赞数")
    private Integer zanCount;
}
