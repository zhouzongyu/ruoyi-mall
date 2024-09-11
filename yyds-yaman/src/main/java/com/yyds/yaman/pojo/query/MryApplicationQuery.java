package com.yyds.yaman.pojo.query;

import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 应用管理 查询 对象
 *
 * @author zzy
 */
@ApiModel(description="应用管理 查询 对象")
@Data
public class MryApplicationQuery {
    @ApiModelProperty("APP_NAME 精确匹配")
    private String appNameLike;

    @ApiModelProperty("ICON_URL 精确匹配")
    private String iconUrl;

    @ApiModelProperty("MP_APP_ID 精确匹配")
    private String mpAppId;

    @ApiModelProperty("MP_APP_SECRET 精确匹配")
    private String mpAppSecret;

    @ApiModelProperty("MINI_PROGRAM_APP_ID 精确匹配")
    private String miniProgramAppId;

    @ApiModelProperty("MINI_PROGRAM_SECRET 精确匹配")
    private String miniProgramSecret;

}
