package com.yyds.yaman.pojo.vo;

import java.time.LocalDateTime;

import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 资讯文章 数据视图对象
 *
 * @author zzy
 */
@ApiModel(description="资讯文章实体类")
@Data
public class MryNewsVO {
    /**
     * ID
     */
    @ApiModelProperty("标题")
    private String id;

    @ApiModelProperty(" 标题")
    @Excel(name = " 标题")
    private String title;


    @ApiModelProperty("排序")
    @Excel(name = "排序")
    private Integer sortNo;

    @ApiModelProperty("图片")
    @Excel(name = "图片")
    private String picUrl;


    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;


    @ApiModelProperty("阅读数")
    @Excel(name = "阅读数")
    private Integer clickCount;

    @ApiModelProperty("赞数")
    @Excel(name = "赞数")
    private Integer zanCount;

    /**
     * 状态 0-正常 1-禁用
     */
    @ApiModelProperty("是否禁用 0-正常 1-禁用")
    private String status;
}
