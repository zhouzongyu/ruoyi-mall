package com.yyds.yaman.domain;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 *  固件版本对象 mry_firmware
 * 
 * @author zzy
 */
@ApiModel(description=" 固件版本对象")
@Data
@TableName("mry_firmware")
public class MryFirmware {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("产品ID")
    private String productId;

    @ApiModelProperty("版本号")
    @Excel(name = "版本号")
    private String version;

    @ApiModelProperty("版本描述")
    @Excel(name = "版本描述")
    private String description;

    @ApiModelProperty("CRC32")
    private String crc32;

    @ApiModelProperty("版本文件地址")
    @Excel(name = "版本文件地址")
    private String filePath;

    @ApiModelProperty("版本文件名称")
    @Excel(name = "版本文件名称")
    private String fileName;


    @ApiModelProperty("发布时间")
    private LocalDateTime createTime;

}
