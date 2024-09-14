package com.yyds.yaman.pojo.vo;

import java.time.LocalDateTime;

import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 广告对象数据视图对象
 *
 * @author zzy
 */
@Data
public class MryAdsVO {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("图片")
    @Excel(name = "图片")
    private String picUrl;

    @ApiModelProperty("链接地址")
    @Excel(name = "链接地址")
    private String lickUrl;

    @ApiModelProperty("是否显示 1-显示 0-隐藏")
    @Excel(name = "是否显示 1-显示 0-隐藏")
    private Integer isShow;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("排序号")
    @Excel(name = "排序号")
    private Integer sortNo;
}
