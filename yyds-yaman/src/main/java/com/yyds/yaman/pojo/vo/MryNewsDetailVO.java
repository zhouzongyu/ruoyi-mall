package com.yyds.yaman.pojo.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 资讯文章 数据视图对象
 *
 * @author zzy
 */
@ApiModel(description="资讯文章详细实体类")
@Data
public class MryNewsDetailVO {
    /**
     * ID
     */
    @ApiModelProperty("标题")
    private String id;

    @ApiModelProperty("标题")
    @Excel(name = " 标题")
    private String title;

    @ApiModelProperty("正文")
    private String content;


    @ApiModelProperty("排序")
    private Integer sortNo;

    @ApiModelProperty("图片")
    private String picUrl;

    @ApiModelProperty("视频地址")
    private String videoUrl;


    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;


    @ApiModelProperty("阅读数")
    @Excel(name = "阅读数")
    private Integer clickCount;

    @ApiModelProperty("赞数")
    @Excel(name = "赞数")
    private Integer zanCount;
}
