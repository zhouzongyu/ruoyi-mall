package com.ruoyi.common.core.domain.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChangeUserStatusParam {
    @ApiModelProperty(value = "状态 0=正常,1=停用")
    private String status;
}
