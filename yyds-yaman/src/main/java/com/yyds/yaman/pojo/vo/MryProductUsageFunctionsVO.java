package com.yyds.yaman.pojo.vo;

import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 产品使用方法和功能说明 数据视图对象
 * 
 * @author zzy
 */
@Data
public class MryProductUsageFunctionsVO  {
    @ApiModelProperty(value = "说明ID",required = true)
    private String id;


    @ApiModelProperty(value = "说明标题",required = false)
    private String title;
    /**
     * 使用方法
     */
    @ApiModelProperty(value = "说明内容",required = true)
    private String content;

    @ApiModelProperty(value = "图片",required = false)
    private String picUrl;
}
