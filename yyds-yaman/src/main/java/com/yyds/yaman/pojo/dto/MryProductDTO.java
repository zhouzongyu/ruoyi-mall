package com.yyds.yaman.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 产品管理 DTO 对象
 *
 * @author zzy
 */
@Data
public class MryProductDTO {
    private String id;
    private String name;
    private Integer type;
    private Integer model;
    private Integer communication;
    private Integer networking;
    private String gear;
    private String function;
    private String spec;
    private String picUrl;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer deleteFlag;
}
