package com.yyds.yaman.domain;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 应用管理对象 mry_application
 * 
 * @author zzy
 */
@ApiModel(description="平台资料配置实体类")
@Data
@TableName("mry_application")
public class MryApplication {
    private static final long serialVersionUID = 1L;

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
