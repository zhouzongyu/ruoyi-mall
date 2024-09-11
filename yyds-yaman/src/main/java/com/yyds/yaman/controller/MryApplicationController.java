package com.yyds.yaman.controller;

import java.util.List;

import com.yyds.yaman.pojo.query.MryApplicationQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.enums.BusinessType;
import com.yyds.yaman.domain.MryApplication;
import com.yyds.yaman.service.MryApplicationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
/**
 * 应用管理Controller
 *
 * @author zzy
 * @date 2024-09-11
 */
@Api(tags ="应用管理接口列表")
@RestController
@RequestMapping("/yaman/mryApplication")
public class MryApplicationController extends BaseController {
    @Autowired
    private MryApplicationService service;

//    @ApiOperation("查询应用管理列表")
//    @PreAuthorize("@ss.hasPermi('yaman:mryApplication:list')")
//    @PostMapping("/list")
//    public ResponseEntity<Page<MryApplication>> list(@RequestBody MryApplicationQuery query, Pageable page) {
//        List<MryApplication> list = service.selectList(query, page);
//        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
//    }

//    @ApiOperation("导出应用管理列表")
//    @PreAuthorize("@ss.hasPermi('yaman:mryApplication:export')")
//    @Log(title = "应用管理", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public ResponseEntity<String> export(MryApplicationQuery query) {
//        List<MryApplication> list = service.selectList(query, null);
//        ExcelUtil<${className.vo}> util = new ExcelUtil<>(${className.vo}.class);
//        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "应用管理数据"));
//    }

    @ApiOperation("获取应用管理详细信息")
    @PreAuthorize("@ss.hasPermi('yaman:mryApplication:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<MryApplication> getInfo(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.selectById(id));
    }

//    @ApiOperation("新增应用管理")
//    @PreAuthorize("@ss.hasPermi('yaman:mryApplication:add')")
//    @Log(title = "应用管理", businessType = BusinessType.INSERT)
//    @PostMapping
//    public ResponseEntity<Integer> add(@RequestBody MryApplication mryApplication) {
//        return ResponseEntity.ok(service.insert(mryApplication));
//    }

    @ApiOperation("修改应用管理")
    @PreAuthorize("@ss.hasPermi('yaman:mryApplication:edit')")
    @Log(title = "应用管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody MryApplication mryApplication) {
        return ResponseEntity.ok(service.update(mryApplication));
    }

    @ApiOperation("删除应用管理")
    @PreAuthorize("@ss.hasPermi('yaman:mryApplication:remove')")
    @Log(title = "应用管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable String[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
