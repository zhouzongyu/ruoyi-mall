package com.ruoyi.common.core.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class FileUploadParam {
    @ApiModelProperty(value = "文件")
    private MultipartFile file;

    @ApiModelProperty(value = "文件类型 1-图片 2-视频")
    private Integer type;

    @ApiModelProperty(value = "文件所属模块")
    private String model;
}
