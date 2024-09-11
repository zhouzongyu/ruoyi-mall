package com.yyds.yaman.pojo.dto;

import lombok.Data;
/**
 * 产品使用方法和功能说明 DTO 对象
 *
 * @author zzy
 */
@Data
public class MryProductUsageFunctionsDTO {
    private String id;
    private String content;
    private String title;
    private String pics;
    private String productId;
    private Integer type;
}
