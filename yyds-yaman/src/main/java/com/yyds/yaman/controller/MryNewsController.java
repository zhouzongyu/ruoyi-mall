package com.yyds.yaman.controller;

import java.util.List;

import com.yyds.yaman.pojo.query.MryNewsQuery;
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
import com.yyds.yaman.domain.MryNews;
import com.yyds.yaman.service.MryNewsService;
/**
 * 资讯文章Controller
 *
 * @author zzy
 * @date 2024-09-11
 */
@Api(tags ="资讯文章接口列表")
@RestController
@RequestMapping("/yaman/news")
public class MryNewsController extends BaseController {
    @Autowired
    private MryNewsService service;

    @ApiOperation("查询资讯文章列表")
    @PreAuthorize("@ss.hasPermi('yaman:news:list')")
    @GetMapping("/list")
    public ResponseEntity<Page<MryNews>> list(@RequestBody MryNewsQuery query, Pageable page) {
        List<MryNews> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

//    @ApiOperation("导出资讯文章列表")
//    @PreAuthorize("@ss.hasPermi('yaman:mryNews:export')")
//    @Log(title = "资讯文章", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public ResponseEntity<String> export(MryNewsQuery query) {
//        List<MryNews> list = service.selectList(query, null);
//        ExcelUtil<MryNewsVo> util = new ExcelUtil<>(MryNewsVo.class);
//        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "资讯文章数据"));
//    }

    @ApiOperation("获取资讯文章详细信息")
    @PreAuthorize("@ss.hasPermi('yaman:news:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<MryNews> getInfo(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增资讯文章")
    @PreAuthorize("@ss.hasPermi('yaman:news:add')")
    @Log(title = "资讯文章", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody MryNews mryNews) {
        return ResponseEntity.ok(service.insert(mryNews));
    }

    @ApiOperation("修改资讯文章")
    @PreAuthorize("@ss.hasPermi('yaman:news:edit')")
    @Log(title = "资讯文章", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody MryNews mryNews) {
        return ResponseEntity.ok(service.update(mryNews));
    }

    @ApiOperation("删除资讯文章")
    @PreAuthorize("@ss.hasPermi('yaman:news:remove')")
    @Log(title = "资讯文章", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable String[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
