package com.ruoyi.web.controller.common;

import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.domain.model.FileUploadParam;
import com.ruoyi.common.core.domain.vo.FileUploadResultVo;
import com.ruoyi.common.utils.OssUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Api(tags = "文件上传接口")
@RequestMapping("/sys/file")
public class OssController {
    @Autowired
    OssUtils ossUtils;

    @ApiOperation("上传文件" )
    @PostMapping("upload")
    public CommonResult<FileUploadResultVo> uploadFile(FileUploadParam fileUploadParam) {
        //返回上传oss的url
        String url = ossUtils.uploadOneFile(fileUploadParam.getFile());

        FileUploadResultVo resultVo = new FileUploadResultVo();
        resultVo.setFileName(fileUploadParam.getFile().getOriginalFilename());
        resultVo.setUrl(url);
        return CommonResult.data(resultVo);
    }

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
