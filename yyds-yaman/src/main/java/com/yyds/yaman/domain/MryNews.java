package com.yyds.yaman.domain;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 资讯文章对象 mry_news
 * 
 * @author zzy
 */
@ApiModel(description="资讯文章对象")
@Data
@TableName("mry_news")
public class MryNews {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty(" 标题")
    @Excel(name = " 标题")
    private String title;

    @ApiModelProperty("正文")
    @Excel(name = "正文")
    private String content;

    @ApiModelProperty("排序")
    @Excel(name = "排序")
    private Integer sortNo;

    @ApiModelProperty("图片")
    @Excel(name = "图片")
    private String picUrl;

    @ApiModelProperty("视频")
    @Excel(name = "视频")
    private String videoUrl;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("删除标识")
    @Excel(name = "删除标识")
    private Integer deleteFlag;

    @ApiModelProperty("阅读数")
    @Excel(name = "阅读数")
    private Integer clickCount;

    @ApiModelProperty("赞数")
    @Excel(name = "赞数")
    private Integer zanCount;

}
