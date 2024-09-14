package com.yyds.yaman.pojo.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MryMemberUpdateParam {
    @NotBlank(message = "用户ID不能为空")
    @ApiModelProperty(value = "用户ID", required = true)
    private String id;


    @ApiModelProperty(value = "会员号", required = false)
    private String vipNumber;


    @ApiModelProperty(value = "备注", required = false)
    private String remark;


}
