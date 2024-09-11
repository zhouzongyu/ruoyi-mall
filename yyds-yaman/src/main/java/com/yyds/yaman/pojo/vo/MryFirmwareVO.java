package com.yyds.yaman.pojo.vo;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import lombok.Data;
/**
 *  固件版本 数据视图对象
 * 
 * @author zzy
 */
@Data
public class MryFirmwareVO  {
   /** ID */
    private Integer id;
   /** 版本号 */
    @Excel(name = "版本号")
    private String version;
   /** 版本描述 */
    @Excel(name = "版本描述")
    private String description;
   /** 版本文件地址 */
    @Excel(name = "版本文件地址")
    private String filePath;
   /** 版本文件名称 */
    @Excel(name = "版本文件名称")
    private String fileName;
   /** 应用ID */
    @Excel(name = "应用ID")
    private String applicationId;
   /** 发布时间 */
    private LocalDateTime createTime;
}
