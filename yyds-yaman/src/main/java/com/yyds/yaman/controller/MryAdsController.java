package com.yyds.yaman.controller;

import java.util.List;

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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.enums.BusinessType;
import com.yyds.yaman.domain.MryAds;
import com.yyds.yaman.service.MryAdsService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 运营中心-推广链接接口列表
 *
 * @author zzy
 * @date 2024-09-14
 */
@Api(tags = "运营中心-推广链接接口列表")
@RestController
@RequestMapping("/yaman/ads")
public class MryAdsController extends BaseController {
    @Autowired
    private MryAdsService service;

//    @ApiOperation("查询推广链接列表")
//    @PreAuthorize("@ss.hasPermi('yaman:ads:list')")
//    @PostMapping("/list")
//    public ResponseEntity<Page<${className.domain}>> list(@RequestBody ${className.query} query, Pageable page) {
//        List<${className.domain}> list = service.selectList(query, page);
//        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
//    }

    @ApiOperation("获取推广链接详细信息")
    @PreAuthorize("@ss.hasPermi('yaman:ads:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<MryAds> getInfo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增推广链接")
    @PreAuthorize("@ss.hasPermi('yaman:ads:add')")
    @Log(title = "推广链接", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody MryAds mryAds) {
        return ResponseEntity.ok(service.insert(mryAds));
    }

    @ApiOperation("修改推广链接")
    @PreAuthorize("@ss.hasPermi('yaman:ads:edit')")
    @Log(title = "推广链接", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody MryAds mryAds) {
        return ResponseEntity.ok(service.update(mryAds));
    }

    @ApiOperation("删除推广链接")
    @PreAuthorize("@ss.hasPermi('yaman:ads:remove')")
    @Log(title = "推广链接", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Integer[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
