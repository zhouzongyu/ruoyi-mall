package com.yyds.yaman.domain;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 广告对象 mry_ads
 * 
 * @author zzy
 */
@ApiModel(description="广告对象")
@Data
@TableName("mry_ads")
public class MryAds {
    private static final long serialVersionUID = 1L;

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

    @ApiModelProperty("删除标识")
    @Excel(name = "删除标识")
    private Integer deleteFlag;

    @ApiModelProperty("排序号")
    @Excel(name = "排序号")
    private Integer sortNo;

}
