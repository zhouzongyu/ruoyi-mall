package com.yyds.yaman.pojo.query;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 资讯文章 查询 对象
 *
 * @author zzy
 */
@ApiModel(description = "资讯文章编辑实体类")
@Data
public class MryNewsEditParam {

    @NotBlank(message = "id不能为空")
    @ApiModelProperty("资讯ID")
    private String id;

    @NotBlank(message = "标题不能为空")
    @Size(max = 30, message = "标题不能超过30个字符")
    @ApiModelProperty("标题")
    private String title;

    @NotBlank(message = "正文不能为空")
    @Size(max = 300, message = "正文内容不能超过300个字符")
    @ApiModelProperty("正文")
    private String content;

    @NotNull(message = "排序号不能为空")
    @ApiModelProperty("排序号")
    private Integer sortNo;

    @NotBlank(message = "图片不能为空")
    @ApiModelProperty("图片")
    private String picUrl;

    @ApiModelProperty("视频")
    private String videoUrl;
}
