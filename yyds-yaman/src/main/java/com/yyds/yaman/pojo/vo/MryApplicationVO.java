package com.yyds.yaman.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 应用管理 数据视图对象
 * 
 * @author zzy
 */
@Data
public class MryApplicationVO  {
    @NotNull(message = "ID不能为空")
    @ApiModelProperty("ID")
    private Integer id;

    @Size(min = 1, max = 20, message = "应用名称长度不能超过20个字符")
    @NotBlank(message = "应用名称不能为空")
    @ApiModelProperty("应用名称")
    private String appName;

    @NotBlank(message = "小程序图标不能为空")
    @ApiModelProperty("小程序图标")
    private String iconUrl;

    @Size(min = 1, max = 20, message = "公众号APPID长度不能超过20个字符")
    @NotBlank(message = "公众号APPID不能为空")
    @ApiModelProperty("公众号APPID")
    private String mpAppId;

    @Size(min = 1, max = 32, message = "公众号AppSecret长度不能超过32个字符")
    @NotBlank(message = "公众号AppSecret不能为空")
    @ApiModelProperty("公众号AppSecret")
    private String mpAppSecret;

    @Size(min = 1, max = 20, message = "小程序APPID不能超过20个字符")
    @NotBlank(message = "小程序APPID不能为空")
    @ApiModelProperty("小程序APPID")
    private String miniProgramAppId;


    @Size(min = 1, max = 32, message = "小程序Secret长度不能超过32个字符")
    @NotBlank(message = "小程序Secret不能为空")
    @ApiModelProperty("小程序Secret")
    private String miniProgramSecret;

}
