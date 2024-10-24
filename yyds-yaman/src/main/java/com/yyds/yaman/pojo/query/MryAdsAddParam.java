package com.yyds.yaman.pojo.query;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

/**
 * 广告查询 对象
 *
 * @author zzy
 */
@Data
public class MryAdsAddParam {

    @ApiModelProperty("广告图片")
    private String picUrl;

    @Max(value = 300, message = "链接地址长度不能超过300")
    @NotBlank(message = "链接地址不能为空")
    @ApiModelProperty("广告链接地址")
    private String lickUrl;

    @ApiModelProperty("是否显示 1-显示 0-隐藏")
    @Excel(name = "是否显示 1-显示 0-隐藏")
    private Integer isShow;


    @ApiModelProperty("排序号")
    @Excel(name = "排序号")
    private Integer sortNo;
}
