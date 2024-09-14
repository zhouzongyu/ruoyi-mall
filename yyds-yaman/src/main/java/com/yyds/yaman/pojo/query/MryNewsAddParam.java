package com.yyds.yaman.pojo.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 资讯文章 查询 对象
 *
 * @author zzy
 */
@ApiModel(description="资讯文章新增实体类")
@Data
public class MryNewsAddParam {
    @NotBlank(message = "标题不能为空")
    @ApiModelProperty("标题")
    private String title;

    @NotBlank(message = "正文不能为空")
    @ApiModelProperty("正文")
    private String content;

    @NotNull(message = "排序号不能为空")
    @ApiModelProperty("排序号")
    private Integer sortNo;

    @NotBlank(message = "图片不能为空")
    @ApiModelProperty("图片")
    private String picUrl;

    @ApiModelProperty("视频地址")
    private String videoUrl;
}
