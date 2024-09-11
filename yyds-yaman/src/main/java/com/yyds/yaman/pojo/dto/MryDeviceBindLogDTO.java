package com.yyds.yaman.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 设备绑定记录 DTO 对象
 *
 * @author zzy
 */
@Data
public class MryDeviceBindLogDTO {
    private String id;
    private String deviceId;
    private Integer action;
    private String userId;
    private String userName;
    private LocalDateTime createTime;
}
