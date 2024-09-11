package com.yyds.yaman.pojo.vo;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 应用管理 数据视图对象
 * 
 * @author zzy
 */
@Data
public class MryApplicationVO  {
   /** ID */
    private String id;
   /** APP_NAME */
    @Excel(name = "APP_NAME")
    private String appName;
   /** ICON_URL */
    @Excel(name = "ICON_URL")
    private String iconUrl;
   /** MP_APP_ID */
    @Excel(name = "MP_APP_ID")
    private String mpAppId;
   /** MP_APP_SECRET */
    @Excel(name = "MP_APP_SECRET")
    private String mpAppSecret;
   /** MINI_PROGRAM_APP_ID */
    @Excel(name = "MINI_PROGRAM_APP_ID")
    private String miniProgramAppId;
   /** MINI_PROGRAM_SECRET */
    @Excel(name = "MINI_PROGRAM_SECRET")
    private String miniProgramSecret;
   /** CREATE_TIME */
    private LocalDateTime createTime;
}
