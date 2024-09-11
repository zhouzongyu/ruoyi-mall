package com.yyds.yaman.controller;

import java.util.List;

import com.yyds.yaman.pojo.query.MryFirmwareQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.enums.BusinessType;
import com.yyds.yaman.domain.MryFirmware;
import com.yyds.yaman.service.MryFirmwareService;
/**
 *  固件版本Controller
 *
 * @author zzy
 * @date 2024-09-11
 */
@Api(tags =" 固件版本接口列表")
@RestController
@RequestMapping("yaman/firmware")
public class MryFirmwareController extends BaseController {
    @Autowired
    private MryFirmwareService service;

    @ApiOperation("查询 固件版本列表")
    @PreAuthorize("@ss.hasPermi('yaman/firmware:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<MryFirmware>> list(@RequestBody MryFirmwareQuery query, Pageable page) {
        List<MryFirmware> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
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

    @ApiOperation("获取 固件版本详细信息")
    @PreAuthorize("@ss.hasPermi('yaman/firmware:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<MryFirmware> getInfo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增 固件版本")
    @PreAuthorize("@ss.hasPermi('yaman/firmware:add')")
    @Log(title = " 固件版本", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody MryFirmware mryFirmware) {
        return ResponseEntity.ok(service.insert(mryFirmware));
    }

    @ApiOperation("修改 固件版本")
    @PreAuthorize("@ss.hasPermi('yaman/firmware:edit')")
    @Log(title = " 固件版本", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody MryFirmware mryFirmware) {
        return ResponseEntity.ok(service.update(mryFirmware));
    }

    @ApiOperation("删除 固件版本")
    @PreAuthorize("@ss.hasPermi('yaman/firmware:remove')")
    @Log(title = " 固件版本", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable String[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
