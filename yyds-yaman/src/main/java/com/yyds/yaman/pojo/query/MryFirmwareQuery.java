package com.yyds.yaman.pojo.query;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *  固件版本 查询 对象
 *
 * @author zzy
 */
@ApiModel(description=" 固件版本")
@JsonIgnoreProperties(ignoreUnknown = true) //忽略前端的传递的额外字段
@Data
public class MryFirmwareQuery {
    /**
     * 排序的列字段
     */
    private String column;

    /**
     * 排序规则默认降序 降序:false 升序:true
     */
    private Boolean asc;

    public Boolean getAsc() {
        return asc == null ? false : asc;
    }

}
