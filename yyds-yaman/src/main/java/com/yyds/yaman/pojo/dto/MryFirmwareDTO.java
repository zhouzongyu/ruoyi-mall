package com.yyds.yaman.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 *  固件版本 DTO 对象
 *
 * @author zzy
 */
@Data
public class MryFirmwareDTO {
    private Integer id;
    private String version;
    private String description;
    private String filePath;
    private String fileName;
    private String applicationId;
    private LocalDateTime createTime;
}
