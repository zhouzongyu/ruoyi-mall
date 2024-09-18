package com.ruoyi.web.controller.common;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.domain.model.FileUploadParam;
import com.ruoyi.common.core.domain.vo.FileUploadResultVo;
import com.ruoyi.common.utils.OssUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.ServerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Api(tags = "文件上传接口")
@RequestMapping("/sys/file")
public class OssController {

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    OssUtils ossUtils;

    /**
     * 通用上传请求
     */

    @ApiOperation("通用上传请求")
    @PostMapping("/upload")
    public CommonResult<FileUploadResultVo> commonUploadFile(
            @ApiParam(value = "上传的文件", required = true) @RequestParam("file") MultipartFile file,
            @ApiParam(value = "文件类型，1-图片，2-视频", required = false) @RequestParam(value = "type", required = false) Integer type,
            @ApiParam(value = "文件所属模块", required = false) @RequestParam(value = "model", required = false) String model) throws Exception {
        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;

            FileUploadResultVo resultVo = new FileUploadResultVo();
            resultVo.setFilePath(fileName);
            resultVo.setFileName(file.getOriginalFilename());
            resultVo.setUrl(url);
            return CommonResult.data(resultVo);

        } catch (Exception e) {
            return CommonResult.error(e.getMessage());
        }
    }

//    @ApiOperation("上传文件" )
//    @PostMapping("upload")
//    public CommonResult<FileUploadResultVo> uploadFile(FileUploadParam fileUploadParam) {
//        //返回上传oss的url
//        String url = ossUtils.uploadOneFile(fileUploadParam.getFile());
//
//        FileUploadResultVo resultVo = new FileUploadResultVo();
//        resultVo.setFileName(fileUploadParam.getFile().getOriginalFilename());
//        resultVo.setUrl(url);
//        return CommonResult.data(resultVo);
//    }

    @PostMapping("uploadArrayFile")
    public List<String> uploadArrayFile(MultipartFile[] files) {
        //返回上传oss的url
        return ossUtils.uploadArrayFile(files);
    }

    @PostMapping("deleteFile")
    public boolean deleteFile(@RequestBody String fileUrl) {
        //返回是否删除成功
        return ossUtils.deleteFile(fileUrl);
    }
}
