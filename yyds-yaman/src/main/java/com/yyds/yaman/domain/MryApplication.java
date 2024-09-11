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
@ApiModel(description="应用管理对象")
@Data
@TableName("mry_application")
public class MryApplication {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("APP_NAME")
    @Excel(name = "APP_NAME")
    private String appName;

    @ApiModelProperty("ICON_URL")
    @Excel(name = "ICON_URL")
    private String iconUrl;

    @ApiModelProperty("MP_APP_ID")
    @Excel(name = "MP_APP_ID")
    private String mpAppId;

    @ApiModelProperty("MP_APP_SECRET")
    @Excel(name = "MP_APP_SECRET")
    private String mpAppSecret;

    @ApiModelProperty("MINI_PROGRAM_APP_ID")
    @Excel(name = "MINI_PROGRAM_APP_ID")
    private String miniProgramAppId;

    @ApiModelProperty("MINI_PROGRAM_SECRET")
    @Excel(name = "MINI_PROGRAM_SECRET")
    private String miniProgramSecret;

    @ApiModelProperty("CREATE_TIME")
    private LocalDateTime createTime;

}
