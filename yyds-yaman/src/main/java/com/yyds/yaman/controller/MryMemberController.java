package com.yyds.yaman.controller;

import java.util.List;

import com.yyds.yaman.pojo.query.MryMemberQuery;
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
import com.yyds.yaman.domain.MryMember;
import com.yyds.yaman.service.MryMemberService;

/**
 * 会员Controller
 *
 * @author zzy
 * @date 2024-09-11
 */
@Api(tags ="会员接口列表")
@RestController
@RequestMapping("/yaman/member")
public class MryMemberController extends BaseController {
    @Autowired
    private MryMemberService service;

    @ApiOperation("查询会员列表")
    @PreAuthorize("@ss.hasPermi('yaman:member:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<MryMember>> list(@RequestBody MryMemberQuery query, Pageable page) {
        List<MryMember> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

//    @ApiOperation("导出会员列表")
//    @PreAuthorize("@ss.hasPermi('yaman:mryMember:export')")
//    @Log(title = "会员", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public ResponseEntity<String> export(MryMemberQuery query) {
//        List<MryMember> list = service.selectList(query, null);
//        ExcelUtil<MryMemberVo}> util = new ExcelUtil<>(MryMemberVo}.class);
//        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "会员数据"));
//    }

    @ApiOperation("获取会员详细信息")
    @PreAuthorize("@ss.hasPermi('yaman:member:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<MryMember> getInfo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.selectById(id));
    }

//    @ApiOperation("新增会员")
//    @PreAuthorize("@ss.hasPermi('yaman:mryMember:add')")
//    @Log(title = "新增会员", businessType = BusinessType.INSERT)
//    @PostMapping
//    public ResponseEntity<Integer> add(@RequestBody MryMember mryMember) {
//        return ResponseEntity.ok(service.insert(mryMember));
//    }

    @ApiOperation("修改会员")
    @PreAuthorize("@ss.hasPermi('yaman:member:edit')")
    @Log(title = "修改会员", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody MryMember mryMember) {
        return ResponseEntity.ok(service.update(mryMember));
    }

    @ApiOperation("删除会员")
    @PreAuthorize("@ss.hasPermi('yaman:member:remove')")
    @Log(title = "删除会员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable String[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
