package com.yyds.yaman.pojo.query;

import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 资讯文章 查询 对象
 *
 * @author zzy
 */
@ApiModel(description="资讯文章 查询 对象")
@Data
public class MryNewsQuery {
    @ApiModelProperty(" 标题 精确匹配")
    private String title;

    @ApiModelProperty("正文 精确匹配")
    private String content;

    @ApiModelProperty("排序 精确匹配")
    private Integer sortNo;

    @ApiModelProperty("图片 精确匹配")
    private String picUrl;

    @ApiModelProperty("视频 精确匹配")
    private String videoUrl;

    @ApiModelProperty("删除标识 精确匹配")
    private Integer deleteFlag;

    @ApiModelProperty("阅读数 精确匹配")
    private Integer clickCount;

    @ApiModelProperty("赞数 精确匹配")
    private Integer zanCount;

}
