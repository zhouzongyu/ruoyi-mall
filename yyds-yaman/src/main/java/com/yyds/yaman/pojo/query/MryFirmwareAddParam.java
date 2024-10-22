package com.yyds.yaman.pojo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 *  固件版本 查询 对象
 *
 * @author zzy
 */
@ApiModel(description="固件版本新增实体类")
@Data
public class MryFirmwareAddParam {

    @NotBlank(message = "版本号不能为空")
    @ApiModelProperty("版本号")
    private String version;

    @NotBlank(message = "CRC32不能为空")
    @ApiModelProperty("CRC32")
    private String crc32;

    @ApiModelProperty("版本描述")
    private String description;

    @ApiModelProperty("程序包下载地址")
    private String filePath;

    @ApiModelProperty("程序包名称")
    private String fileName;

    @NotBlank(message = "产品型号不能为空")
    @ApiModelProperty("产品型号")
    private String productModel;


}
