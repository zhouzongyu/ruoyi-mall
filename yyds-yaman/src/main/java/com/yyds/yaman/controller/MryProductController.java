package com.yyds.yaman.controller;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.query.SysUserPageParam;
import com.ruoyi.common.core.domain.vo.SysUserVo;
import com.ruoyi.common.core.page.PageVo;
import com.yyds.yaman.convert.MryProductConvert;
import com.yyds.yaman.domain.MryProduct;
import com.yyds.yaman.pojo.query.MryProductAddParam;
import com.yyds.yaman.pojo.query.MryProductEditParam;
import com.yyds.yaman.pojo.query.MryProductQuery;
import com.yyds.yaman.pojo.vo.MryProductDetailVo;
import com.yyds.yaman.pojo.vo.MryProductVO;
import com.yyds.yaman.service.MryProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
    public CommonResult<PageVo<MryProductVO>> list(MryProductQuery query,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                   @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
//        List<SysUser> list = userService.selectUserPage(query, pageNum, pageSize);
//        List<SysUserVo> users  = list.stream().map(item -> {
//            SysUserVo sysUserVo = new SysUserVo();
//            sysUserVo.setUserId(item.getUserId());
//            sysUserVo.setUserName(item.getUserName());
//            sysUserVo.setNickName(item.getNickName());
//            sysUserVo.setPhone(item.getPhonenumber());
//            sysUserVo.setRoleId(item.getRoleId());
//            sysUserVo.setRoleName(roleService.selectRoleById(item.getRoleId()).getRoleName());
//            sysUserVo.setMeuns(menuService.getMenuFunctionListByRoleId(item.getRoleId()));
//            return sysUserVo;
//        }).collect(Collectors.toList());
//
        PageVo<MryProductVO> resultPage = new PageVo<>();
//        resultPage.setRecords(users);
//        resultPage.setCurrent(pageNum);
//        resultPage.setSize(pageSize);
//        if (list instanceof com.github.pagehelper.Page) {
//            com.github.pagehelper.Page<?> page = (com.github.pagehelper.Page<?>) list;
//            resultPage.setTotal(page.getTotal());
//            resultPage.setPages(page.getPages());
//        }
        return CommonResult.data(resultPage);
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
    public CommonResult<MryProductDetailVo> getInfo(@PathVariable("id") String id) {
        //return ResponseEntity.ok(service.selectById(id));
        return CommonResult.ok();
    }

    @ApiOperation("新增产品")
    @PreAuthorize("@ss.hasPermi('yaman:product:add')")
    @Log(title = "产品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity add(@Validated @RequestBody MryProductAddParam mryProductAddParam) {
       // return ResponseEntity.ok(service.insert(mryProduct));
        return ResponseEntity.ok(1);
    }

    @ApiOperation("修改产品")
    @PreAuthorize("@ss.hasPermi('yaman:product:edit')")
    @Log(title = "产品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody MryProductEditParam mryProductEditParam) {
      //  return ResponseEntity.ok(service.update(mryProduct));
        return ResponseEntity.ok(1);
    }

    @ApiOperation("删除产品")
    @PreAuthorize("@ss.hasPermi('yaman:mryProduct:remove')")
    @Log(title = "产品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{id}")
    public ResponseEntity<Integer> remove(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(id));
    }
}
