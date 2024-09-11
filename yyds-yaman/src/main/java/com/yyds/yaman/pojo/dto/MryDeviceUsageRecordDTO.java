package com.yyds.yaman.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 设备使用记录 DTO 对象
 *
 * @author zzy
 */
@Data
public class MryDeviceUsageRecordDTO {
    private Integer id;
    private String userId;
    private String deviceId;
    private LocalDateTime usageTime;
    private Integer duration;
    private String mode;
    private String gear;
}
