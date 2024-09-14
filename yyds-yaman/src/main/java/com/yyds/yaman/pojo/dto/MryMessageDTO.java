package com.yyds.yaman.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 【请填写功能名称】 DTO 对象
 *
 * @author zzy
 */
@Data
public class MryMessageDTO {
    private Integer id;
    private String msgTitle;
    private String msgContent;
    private Integer msgStatus;
    private String areas;
    private LocalDateTime createTime;
    private LocalDateTime publishTime;
    private Integer deleteFlag;
}
