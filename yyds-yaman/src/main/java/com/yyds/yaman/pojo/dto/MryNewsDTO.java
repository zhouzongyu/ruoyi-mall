package com.yyds.yaman.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 资讯文章 DTO 对象
 *
 * @author zzy
 */
@Data
public class MryNewsDTO {
    private String id;
    private String title;
    private String content;
    private Integer sortNo;
    private String picUrl;
    private String videoUrl;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer deleteFlag;
    private Integer clickCount;
    private Integer zanCount;
}
