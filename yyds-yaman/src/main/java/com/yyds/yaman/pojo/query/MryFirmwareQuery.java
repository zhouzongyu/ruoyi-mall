package com.yyds.yaman.pojo.query;

import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *  固件版本 查询 对象
 *
 * @author zzy
 */
@ApiModel(description=" 固件版本 查询 对象")
@Data
public class MryFirmwareQuery {
    @ApiModelProperty("版本号 精确匹配")
    private String version;

    @ApiModelProperty("版本描述 精确匹配")
    private String description;

    @ApiModelProperty("版本文件地址 精确匹配")
    private String filePath;

    @ApiModelProperty("版本文件名称 精确匹配")
    private String fileNameLike;

    @ApiModelProperty("应用ID 精确匹配")
    private String applicationId;

}
