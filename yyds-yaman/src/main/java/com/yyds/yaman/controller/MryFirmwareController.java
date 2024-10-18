package com.yyds.yaman.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.page.PageVo;
import com.yyds.yaman.domain.MryProduct;
import com.yyds.yaman.pojo.query.MryFirmwareAddParam;
import com.yyds.yaman.pojo.query.MryFirmwareEditParam;
import com.yyds.yaman.pojo.query.MryFirmwareQuery;
import com.yyds.yaman.pojo.query.MryMemberQuery;
import com.yyds.yaman.pojo.vo.MryFirmwareVO;
import com.yyds.yaman.pojo.vo.MryMemberVO;
import com.yyds.yaman.pojo.vo.MryProductVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.enums.BusinessType;
import com.yyds.yaman.domain.MryFirmware;
import com.yyds.yaman.service.MryFirmwareService;

/**
 * 固件版本Controller
 *
 * @author zzy
 * @date 2024-09-11
 */
@Api(tags = " 固件版本管理接口" )
@RestController
@RequestMapping("yaman/firmware" )
public class MryFirmwareController extends BaseController {
    @Autowired
    private MryFirmwareService service;

    @ApiOperation("分页查询固件版本列表" )
    @PreAuthorize("@ss.hasPermi('yaman/firmware:list')" )
    @GetMapping("/list" )
    public CommonResult<PageVo<MryFirmwareVO>> list(
            MryFirmwareQuery query,
            @RequestParam(value = "pageNum", defaultValue = "1" ) int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10" ) int pageSize) {
        List<MryFirmware> list = service.selectList(query, pageNum, pageSize);
        List<MryFirmwareVO> firmwareList = list.stream().map(item -> {
            MryFirmwareVO mryProductVO = new MryFirmwareVO();
            mryProductVO.setId(item.getId());
            mryProductVO.setVersion(item.getVersion());
            mryProductVO.setDescription(item.getDescription());
            mryProductVO.setFilePath(item.getFilePath());
            mryProductVO.setFileName(item.getFileName());
            mryProductVO.setCrc32(item.getCrc32());
            mryProductVO.setCreateTime(item.getCreateTime());
            return mryProductVO;
        }).collect(Collectors.toList());

        PageVo<MryFirmwareVO> resultPage = new PageVo<>();
        resultPage.setRecords(firmwareList);
        resultPage.setCurrent(pageNum);
        resultPage.setSize(pageSize);
        if (list instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page<?> page = (com.github.pagehelper.Page<?>) list;
            resultPage.setTotal(page.getTotal());
            resultPage.setPages(page.getPages());
        }
        return CommonResult.data(resultPage);
    }

//    @ApiOperation("导出 固件版本列表")
//    @PreAuthorize("@ss.hasPermi('yaman/firmware:export')")
//    @Log(title = " 固件版本", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public ResponseEntity<String> export(MryFirmwareQuery query) {
//        List<MryFirmware> list = service.selectList(query, null);
//        ExcelUtil<MryFirmwareVo> util = new ExcelUtil<>(MryFirmwareVo.class);
//        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), " 固件版本数据"));
//    }

    @ApiOperation("获取固件版本详细信息" )
    @PreAuthorize("@ss.hasPermi('yaman/firmware:query')" )
    @GetMapping(value = "/{id}" )
    public ResponseEntity<MryFirmware> getInfo(@PathVariable("id" ) Integer id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增固件版本" )
    @PreAuthorize("@ss.hasPermi('yaman/firmware:add')" )
    @Log(title = "固件版本", businessType = BusinessType.INSERT)
    @PostMapping
    public CommonResult add(@Validated @RequestBody MryFirmwareAddParam mryFirmwareAddParam) {
        MryFirmware mryFirmwareEntity = new MryFirmware();
        mryFirmwareEntity.setFileName(mryFirmwareAddParam.getFileName());
        mryFirmwareEntity.setFilePath(mryFirmwareAddParam.getFilePath());
        mryFirmwareEntity.setVersion(mryFirmwareAddParam.getVersion());
        mryFirmwareEntity.setCrc32(mryFirmwareAddParam.getCrc32());
        mryFirmwareEntity.setDescription(mryFirmwareAddParam.getDescription());
        mryFirmwareEntity.setCreateTime(LocalDateTime.now());
        int rows = service.insert(mryFirmwareEntity);
        return rows > 0 ? CommonResult.data("添加固件版本成功") : CommonResult.error("添加固件版本失败");
    }

    @ApiOperation("修改固件版本" )
    @PreAuthorize("@ss.hasPermi('yaman/firmware:edit')" )
    @Log(title = "修改固件版本", businessType = BusinessType.UPDATE)
    @PutMapping
    public CommonResult edit(@Validated @RequestBody MryFirmwareEditParam mryFirmwareEditParam) {
        MryFirmware mryFirmware = service.selectById(mryFirmwareEditParam.getId());
        if(mryFirmware == null) {
            return CommonResult.error("固件版本记录不存在或已被删除");
        }
        mryFirmware.setCrc32(mryFirmwareEditParam.getCrc32());
        mryFirmware.setVersion(mryFirmwareEditParam.getVersion());
        mryFirmware.setDescription(mryFirmwareEditParam.getDescription());
        mryFirmware.setFilePath(mryFirmwareEditParam.getFilePath());
        mryFirmware.setFileName(mryFirmwareEditParam.getFileName());
        int rows = service.update(mryFirmware);
        return rows > 0 ? CommonResult.data("修改成功") : CommonResult.error("修改失败");
    }

    @ApiOperation("删除固件版本" )
    @PreAuthorize("@ss.hasPermi('yaman/firmware:remove')" )
    @Log(title = "删除固件版本", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}" )
    public CommonResult remove(@PathVariable Integer id) {
        int rows = service.deleteById(id);
        return rows > 0 ? CommonResult.data("删除成功") : CommonResult.error("删除失败");

    }
}
