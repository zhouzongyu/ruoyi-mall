package com.ruoyi.common.core.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FileUploadResultVo {
    @ApiModelProperty("文件地址")
    private String url;

    @ApiModelProperty("文件路径")
    private String filePath;

    @ApiModelProperty("文件名称")
    private String fileName;
}
