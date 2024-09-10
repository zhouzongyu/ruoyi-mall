package com.yyds.yaman.controller;
import java.util.List;

import com.ruoyi.common.core.controller.BaseController;
import com.yyds.yaman.convert.MryProductConvert;
import com.yyds.yaman.domain.MryProduct;
import com.yyds.yaman.pojo.query.MryProductQuery;
import com.yyds.yaman.service.MryProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
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
import com.ruoyi.common.enums.BusinessType;
/**
 * 产品管理Controller
 *
 * @author zzy
 * @date 2024-09-10
 */
@Api(tags = "产品管理接口列表")
@RestController
@RequestMapping("/yaman/product")
public class MryProductController extends BaseController {
    @Autowired
    private MryProductService service;
    @Autowired
    private MryProductConvert convert;

    @ApiOperation("查询产品管理列表")
    @PreAuthorize("@ss.hasPermi('yaman:product:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<MryProduct>> list(@RequestBody MryProductQuery query, Pageable page) {
        List<MryProduct> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<MryProduct>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

//    @ApiOperation("导出产品管理列表")
//    @PreAuthorize("@ss.hasPermi('yaman:mryProduct:export')")
//    @Log(title = "产品管理", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public ResponseEntity<String> export(MryProductQuery query) {
//        List<MryProduct> list = service.selectList(query, null);
//        ExcelUtil<${_className.vo}> util = new ExcelUtil<>(${_className.vo}.class);
//        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "产品管理数据"));
//    }

    @ApiOperation("获取产品管理详细信息")
    @PreAuthorize("@ss.hasPermi('yaman:product:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<MryProduct> getInfo(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增产品管理")
    @PreAuthorize("@ss.hasPermi('yaman:product:add')")
    @Log(title = "产品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody MryProduct mryProduct) {
        return ResponseEntity.ok(service.insert(mryProduct));
    }

    @ApiOperation("修改产品管理")
    @PreAuthorize("@ss.hasPermi('yaman:product:edit')")
    @Log(title = "产品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody MryProduct mryProduct) {
        return ResponseEntity.ok(service.update(mryProduct));
    }

    @ApiOperation("删除产品管理")
    @PreAuthorize("@ss.hasPermi('yaman:mryProduct:remove')")
    @Log(title = "产品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable String[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
