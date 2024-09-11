package com.yyds.yaman.pojo.vo;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 应用管理 数据视图对象
 * 
 * @author zzy
 */
@Data
public class MryApplicationVO  {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("应用名称")
    private String appName;

    @ApiModelProperty("小程序图标")
    private String iconUrl;

    @ApiModelProperty("公众号APPID")
    private String mpAppId;

    @ApiModelProperty("公众号AppSecret")
    private String mpAppSecret;

    @ApiModelProperty("小程序APPID")
    private String miniProgramAppId;

    @ApiModelProperty("小程序Secret")
    private String miniProgramSecret;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;
}
