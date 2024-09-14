package com.yyds.yaman.pojo.dto;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 【请填写功能名称】 DTO 对象
 *
 * @author zzy
 */
@Data
public class MryDeviceDTO {
    private String deviceId;
    private String sn;
    private String model;
    private String productId;
    private String productName;
    private String productMode;
    private String userId;
    private LocalDateTime createTime;
    private String usgeProvice;
    private String usgeCity;
    private String usgeArea;
}
