package com.yyds.yaman.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 应用管理 DTO 对象
 *
 * @author zzy
 */
@Data
public class MryApplicationDTO {
    private String id;
    private String appName;
    private String iconUrl;
    private String mpAppId;
    private String mpAppSecret;
    private String miniProgramAppId;
    private String miniProgramSecret;
    private LocalDateTime createTime;
}
