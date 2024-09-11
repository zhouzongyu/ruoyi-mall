package com.yyds.yaman.pojo.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MryProductUsageFunctionAddParam {
    @ApiModelProperty(value = "说明标题",required = true)
    private String title;
    /**
     * 使用方法
     */
    @ApiModelProperty(value = "说明内容",required = true)
    private String content;

    @ApiModelProperty(value = "图片",required = true)
    private String picUrl;

}
