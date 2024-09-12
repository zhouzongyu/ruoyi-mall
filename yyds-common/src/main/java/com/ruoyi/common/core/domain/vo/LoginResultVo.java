package com.ruoyi.common.core.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginResultVo {

    @ApiModelProperty(value = "令牌")
    private String token;
}
