package com.ruoyi.common.core.domain.query;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class SysUserPageParam {
    @ApiModelProperty(value = "用户ID")
    private Long userId;


    @ApiModelProperty(value = "账号名")
    private String userName;

    @ApiModelProperty(value = "用户名称")
    private String nickName;


    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "用户状态 0=正常,1=停用")
    private String status;
}
