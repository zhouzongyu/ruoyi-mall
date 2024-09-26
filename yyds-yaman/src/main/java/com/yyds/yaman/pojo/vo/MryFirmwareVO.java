package com.yyds.yaman.pojo.vo;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 *  固件版本 数据视图对象
 * 
 * @author zzy
 */
@Data
public class MryFirmwareVO  {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("版本号")
    @Excel(name = "版本号")
    private String version;

    @ApiModelProperty("版本描述")
    @Excel(name = "版本描述")
    private String description;

    @ApiModelProperty("程序包下载地址")
    private String filePath;

    @ApiModelProperty("程序包名称")
    private String fileName;

    @ApiModelProperty("CRC32")
    private String crc32;
   /** 发布时间 */
   @ApiModelProperty("发布时间")
   private LocalDateTime createTime;
}
