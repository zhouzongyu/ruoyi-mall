package com.yyds.yaman.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.page.PageVo;
import com.yyds.yaman.pojo.query.MryAdsAddParam;
import com.yyds.yaman.pojo.query.MryAdsEditParam;
import com.yyds.yaman.pojo.query.MryAdsQuery;
import com.yyds.yaman.pojo.query.MryMessageQuery;
import com.yyds.yaman.pojo.vo.MryAdsVO;
import com.yyds.yaman.pojo.vo.MryMessageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @ApiOperation("查询推广链接列表")
    @PreAuthorize("@ss.hasPermi('yaman:ads:list')")
    @GetMapping("/list")
    public CommonResult<PageVo<MryAdsVO>> list(MryAdsQuery query,
                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<MryAds> list = service.selectList(query, pageNum, pageSize);
        List<MryAdsVO> recordList = list.stream().map(item -> {
            MryAdsVO recordVO = new MryAdsVO();
            recordVO.setId(item.getId());
            recordVO.setPicUrl(item.getPicUrl());
            recordVO.setLickUrl(item.getLickUrl());
            recordVO.setIsShow(item.getIsShow());
            recordVO.setSortNo(item.getSortNo());
            recordVO.setCreateTime(item.getCreateTime());
            return recordVO;
        }).collect(Collectors.toList());

        PageVo<MryAdsVO> resultPage = new PageVo<MryAdsVO>();
        resultPage.setRecords(recordList);
        resultPage.setCurrent(pageNum);
        resultPage.setSize(pageSize);
        if (list instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page<?> page = (com.github.pagehelper.Page<?>) list;
            resultPage.setTotal(page.getTotal());
            resultPage.setPages(page.getPages());
        }
        return CommonResult.data(resultPage);
    }

    @ApiOperation("获取推广链接详细信息")
    @PreAuthorize("@ss.hasPermi('yaman:ads:query')")
    @GetMapping(value = "/{id}")
    public CommonResult<MryAds> getInfo(@PathVariable("id") Integer id) {
        return CommonResult.data(service.selectById(id));
    }

    @ApiOperation("新增推广链接")
    @PreAuthorize("@ss.hasPermi('yaman:ads:add')")
    @Log(title = "推广链接", businessType = BusinessType.INSERT)
    @PostMapping
    public CommonResult add(@RequestBody MryAdsAddParam mryAdsAddParam) {
        MryAds mryAds = new MryAds();
        mryAds.setPicUrl(mryAdsAddParam.getPicUrl());
        mryAds.setLickUrl(mryAdsAddParam.getLickUrl());
        mryAds.setIsShow(mryAdsAddParam.getIsShow());
        mryAds.setSortNo(mryAdsAddParam.getSortNo());
        int rows = service.insert(mryAds);
        return rows > 0 ? CommonResult.ok("新增成功").setData(mryAds.getId()) : CommonResult.error("新增失败");
    }

    @ApiOperation("修改推广链接")
    @PreAuthorize("@ss.hasPermi('yaman:ads:edit')")
    @Log(title = "推广链接", businessType = BusinessType.UPDATE)
    @PutMapping
    public CommonResult edit(@RequestBody MryAdsEditParam mryAdsEditParam) {

        MryAds mryAds = service.selectById(mryAdsEditParam.getId());
        if (mryAds == null) {
            return CommonResult.error("推广链接记录不存在");
        }
        mryAds.setPicUrl(mryAdsEditParam.getPicUrl());
        mryAds.setLickUrl(mryAdsEditParam.getLickUrl());
        mryAds.setIsShow(mryAdsEditParam.getIsShow());
        mryAds.setSortNo(mryAdsEditParam.getSortNo());
        int rows = service.update(mryAds);
        return rows > 0 ? CommonResult.ok("修改成功") : CommonResult.error("修改失败");
    }

    @ApiOperation("删除推广链接")
    @PreAuthorize("@ss.hasPermi('yaman:ads:remove')")
    @Log(title = "推广链接", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public CommonResult remove(@PathVariable Integer id) {
        return service.deleteById(id) > 0 ? CommonResult.ok("删除成功") : CommonResult.error("删除失败");

    }
}
