package com.yyds.yaman.pojo.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MryProductUsageFunctionEditParam {
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
