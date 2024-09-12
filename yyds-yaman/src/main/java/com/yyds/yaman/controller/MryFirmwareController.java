package com.yyds.yaman.controller;

import java.util.List;

import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.page.PageVo;
import com.yyds.yaman.pojo.query.MryFirmwareAddParam;
import com.yyds.yaman.pojo.query.MryFirmwareEditParam;
import com.yyds.yaman.pojo.query.MryFirmwareQuery;
import com.yyds.yaman.pojo.query.MryMemberQuery;
import com.yyds.yaman.pojo.vo.MryFirmwareVO;
import com.yyds.yaman.pojo.vo.MryMemberVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
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
    public CommonResult<PageVo<MryFirmwareVO>> list(@RequestParam(value = "pageNum", defaultValue = "1" ) int pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "10" ) int pageSize) {
        //  List<MryMember> list = service.selectList(query, page);
        return CommonResult.ok();
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
    public ResponseEntity<Integer> add(@RequestBody MryFirmwareAddParam mryFirmware) {
        return ResponseEntity.ok(1);
    }

    @ApiOperation("修改 固件版本" )
    @PreAuthorize("@ss.hasPermi('yaman/firmware:edit')" )
    @Log(title = " 固件版本", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody MryFirmwareEditParam mryFirmware) {
        return ResponseEntity.ok(1);
    }

    @ApiOperation("删除 固件版本" )
    @PreAuthorize("@ss.hasPermi('yaman/firmware:remove')" )
    @Log(title = " 固件版本", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}" )
    public ResponseEntity<Integer> remove(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteById(id));
    }
}
