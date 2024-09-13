package com.yyds.yaman.pojo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 产品管理 查询 对象
 *
 * @author zzy
 */
@ApiModel(description="产品管理")
@Data
public class MryProductEditParam {
    @NotBlank(message = "产品ID不能为空")
    @ApiModelProperty(value = "产品ID",required = true)
    private String id;

    @NotBlank(message = "产品名称不能为空")
    @Size(min = 1, max = 30, message = "产品名称长度不能超过30个字符")
    @ApiModelProperty(value = "产品名称",required = true)
    private String name;

    @NotNull(message = "产品类型不能为空")
    @ApiModelProperty(value = "产品类型 1-美容仪",required = true)
    private Integer type;

    //只能输入字母+数字
    @Size(min = 1, max = 30, message = "产品型号长度不能超过30个字符")
    @NotBlank(message = "产品型号不能为空")
    @ApiModelProperty(value = "产品型号",required = true)
    private String model;

    @NotNull(message = "通信方式不能为空")
    @ApiModelProperty(value = "通信方式",required = true)
    private Integer communication;

    @NotNull(message = "配网方式不能为空")
    @ApiModelProperty(value = "配网方式",required = true)
    private Integer networking;

    @ApiModelProperty("档位（ 多个中间用逗号隔开）")
    private String gear;

    @ApiModelProperty("产品功能（ 多个中间用逗号隔开）")
    private String functionType;

    @Size(min = 1, max = 30, message = "产品型号长度不能超过30个字符")
    @NotBlank(message = "规格参数不能为空")
    @ApiModelProperty(value = "规格参数",required = true)
    private String spec;

    @ApiModelProperty(value = "主图", required = true)
    private String picUrl;

    @ApiModelProperty(value = "使用方法", required = false)
    private List<MryProductUsageFunctionEditParam> usages;

    @ApiModelProperty(value = "功能说明", required = false)
    private List<MryProductUsageFunctionEditParam> functions;

}
