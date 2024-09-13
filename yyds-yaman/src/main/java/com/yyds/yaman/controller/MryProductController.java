package com.yyds.yaman.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.page.PageVo;
import com.yyds.yaman.convert.MryProductConvert;
import com.yyds.yaman.domain.MryProduct;
import com.yyds.yaman.domain.MryProductUsageFunctions;
import com.yyds.yaman.pojo.query.MryProductAddParam;
import com.yyds.yaman.pojo.query.MryProductEditParam;
import com.yyds.yaman.pojo.query.MryProductQuery;
import com.yyds.yaman.pojo.query.MryProductUsageFunctionEditParam;
import com.yyds.yaman.pojo.vo.MryProductDetailVo;
import com.yyds.yaman.pojo.vo.MryProductVO;
import com.yyds.yaman.service.MryProductService;
import com.yyds.yaman.service.MryProductUsageFunctionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
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
    private MryProductUsageFunctionsService productUsageFunctionsService;

    @ApiOperation("查询产品列表接口")
    @PreAuthorize("@ss.hasPermi('yaman:product:list')")
    @GetMapping("/list")
    public CommonResult<PageVo<MryProductVO>> list(MryProductQuery query,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                   @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<MryProduct> list = service.selectList(query, pageNum, pageSize);
        List<MryProductVO> productList = list.stream().map(item -> {
            MryProductVO mryProductVO = new MryProductVO();
            mryProductVO.setId(item.getId());
            mryProductVO.setName(item.getName());
            mryProductVO.setType(item.getType());
            mryProductVO.setModel(item.getModel());
            mryProductVO.setPicUrl(item.getPicUrl());
            mryProductVO.setCreateTime(item.getCreateTime());
            mryProductVO.setUpdateTime(item.getUpdateTime());
            return mryProductVO;
        }).collect(Collectors.toList());
//
        PageVo<MryProductVO> resultPage = new PageVo<>();
        resultPage.setRecords(productList);
        resultPage.setCurrent(pageNum);
        resultPage.setSize(pageSize);
        if (list instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page<?> page = (com.github.pagehelper.Page<?>) list;
            resultPage.setTotal(page.getTotal());
            resultPage.setPages(page.getPages());
        }
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

    @ApiOperation("获取产品详细接口")
    @PreAuthorize("@ss.hasPermi('yaman:product:query')")
    @GetMapping(value = "/{id}")
    public CommonResult<MryProductDetailVo> getInfo(@PathVariable("id") String id) {
        MryProduct mryProduct = service.selectById(id);
        if (mryProduct == null) {
            return CommonResult.error("产品记录不存在或已被删除");
        }
        MryProductDetailVo mryProductDetailVo = new MryProductDetailVo();
        BeanUtils.copyProperties(mryProduct, mryProductDetailVo);

        List<MryProductUsageFunctions> usageFunctions = productUsageFunctionsService.getUsageFunctionsByProductId(id);
        List<MryProductUsageFunctionEditParam> usageList = usageFunctions.stream().filter(item -> item.getType() == 1).map(item -> {
            MryProductUsageFunctionEditParam mryProductUsageFunctionEditParam = new MryProductUsageFunctionEditParam();
            BeanUtils.copyProperties(item, mryProductUsageFunctionEditParam);
            return mryProductUsageFunctionEditParam;
        }).collect(Collectors.toList());

        List<MryProductUsageFunctionEditParam> functionList = usageFunctions.stream().filter(item -> item.getType() == 2).map(item -> {
            MryProductUsageFunctionEditParam mryProductUsageFunctionEditParam = new MryProductUsageFunctionEditParam();
            BeanUtils.copyProperties(item, mryProductUsageFunctionEditParam);
            return mryProductUsageFunctionEditParam;
        }).collect(Collectors.toList());
        mryProductDetailVo.setFunctions(functionList);
        mryProductDetailVo.setUsages(usageList);

        return CommonResult.data(mryProductDetailVo);
    }

    @ApiOperation("新增产品")
    @PreAuthorize("@ss.hasPermi('yaman:product:add')")
    @Log(title = "新增产品", businessType = BusinessType.INSERT)
    @PostMapping
    public CommonResult add(@Validated @RequestBody MryProductAddParam mryProductAddParam) {
        return service.addMryProduct(mryProductAddParam);
    }

    @ApiOperation("修改产品")
    @PreAuthorize("@ss.hasPermi('yaman:product:edit')")
    @Log(title = "修改产品", businessType = BusinessType.UPDATE)
    @PutMapping
    public CommonResult edit(@Validated @RequestBody MryProductEditParam mryProductEditParam) {
        return service.updateMryProduct(mryProductEditParam);
    }

    @ApiOperation("删除产品")
    @PreAuthorize("@ss.hasPermi('yaman:product:remove')")
    @Log(title = "删除产品", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public CommonResult remove(@PathVariable String id) {
        MryProduct mryProduct = service.selectById(id);
        if (mryProduct == null) {
            return CommonResult.error("产品记录不存在或已被删除");
        }
        mryProduct.setDeleteFlag(1);
        mryProduct.setUpdateTime(LocalDateTime.now());
        int rows = service.update(mryProduct);
        return rows > 0 ? CommonResult.ok("删除成功") : CommonResult.error("删除失败");
    }


    @ApiOperation("删除产品使用方法和功能说明 ")
    @PreAuthorize("@ss.hasPermi('yaman:product:remove')")
    @Log(title = "删除产品使用方法和功能说明", businessType = BusinessType.DELETE)
    @DeleteMapping("/{productId}/deleteUsageFunction/{id}")
    public CommonResult deleteUsageFunction(@PathVariable String productId, @PathVariable String id) {
        int rows = productUsageFunctionsService.deleteProductUsageFunctionInfoByIdAndProductId(productId, id);
        return rows > 0 ? CommonResult.ok("删除成功") : CommonResult.error("删除失败");
    }
}
