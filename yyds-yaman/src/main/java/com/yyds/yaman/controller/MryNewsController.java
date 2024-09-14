package com.yyds.yaman.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.page.PageVo;
import com.yyds.yaman.pojo.query.MryNewsAddParam;
import com.yyds.yaman.pojo.query.MryNewsEditParam;
import com.yyds.yaman.pojo.query.MryNewsQuery;
import com.yyds.yaman.pojo.vo.MryFirmwareVO;
import com.yyds.yaman.pojo.vo.MryNewsDetailVO;
import com.yyds.yaman.pojo.vo.MryNewsVO;
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
@Api(tags = "资讯文章接口列表")
@RestController
@RequestMapping("/yaman/news")
public class MryNewsController extends BaseController {
    @Autowired
    private MryNewsService newsService;

    @ApiOperation("查询资讯文章列表")
    @PreAuthorize("@ss.hasPermi('yaman:news:list')")
    @GetMapping("/list")
    public CommonResult<PageVo<MryNewsVO>> list(MryNewsQuery query, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<MryNews> list = newsService.selectList(query, pageNum, pageSize);
        List<MryNewsVO> newList = list.stream().map(item -> {
            MryNewsVO newsVO = new MryNewsVO();
            newsVO.setId(item.getId());
            newsVO.setTitle(item.getTitle());
            newsVO.setClickCount(item.getClickCount());
            newsVO.setZanCount(item.getZanCount());
            newsVO.setPicUrl(item.getPicUrl());
            newsVO.setSortNo(item.getSortNo());
            newsVO.setCreateTime(item.getCreateTime());
            return newsVO;
        }).collect(Collectors.toList());

        PageVo<MryNewsVO> resultPage = new PageVo<MryNewsVO>();
        resultPage.setRecords(newList);
        resultPage.setCurrent(pageNum);
        resultPage.setSize(pageSize);
        if (list instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page<?> page = (com.github.pagehelper.Page<?>) list;
            resultPage.setTotal(page.getTotal());
            resultPage.setPages(page.getPages());
        }

        return CommonResult.data(resultPage);
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
    public CommonResult<MryNewsDetailVO> getInfo(@PathVariable("id") String id) {
        MryNews mryNews = newsService.selectById(id);
        if (mryNews == null) {
            return CommonResult.error("数据不存在");
        }
        MryNewsDetailVO mryNewsDetailVO = new MryNewsDetailVO();
        BeanUtils.copyProperties(mryNews, mryNewsDetailVO);
        return CommonResult.data(mryNewsDetailVO);
    }

    @ApiOperation("新增资讯文章")
    @PreAuthorize("@ss.hasPermi('yaman:news:add')")
    @Log(title = "资讯文章", businessType = BusinessType.INSERT)
    @PostMapping
    public CommonResult add(@Validated @RequestBody MryNewsAddParam mryNewsAddParam) {
        MryNews mryNews = new MryNews();
        BeanUtils.copyProperties(mryNewsAddParam, mryNews);
        mryNews.setDeleteFlag(0);
        mryNews.setCreateTime(LocalDateTime.now());
        mryNews.setUpdateTime(LocalDateTime.now());
        mryNews.setClickCount(0);
        mryNews.setZanCount(0);
        return newsService.insert(mryNews) > 0 ? CommonResult.ok() : CommonResult.error("添加失败");
    }

    @ApiOperation("修改资讯文章")
    @PreAuthorize("@ss.hasPermi('yaman:news:edit')")
    @Log(title = "资讯文章", businessType = BusinessType.UPDATE)
    @PutMapping
    public CommonResult edit(@Validated @RequestBody MryNewsEditParam mryNewsEditParam) {
        MryNews mryNews = newsService.selectById(mryNewsEditParam.getId());
        if (mryNews == null) {
            return CommonResult.error("数据不存在");
        }
        mryNews.setContent(mryNewsEditParam.getContent());
        mryNews.setTitle(mryNewsEditParam.getTitle());
        mryNews.setPicUrl(mryNewsEditParam.getPicUrl());
        mryNews.setVideoUrl(mryNewsEditParam.getVideoUrl());
        mryNews.setSortNo(mryNewsEditParam.getSortNo());
        mryNews.setUpdateTime(LocalDateTime.now());
        return newsService.update(mryNews) > 0 ? CommonResult.ok("修改成功") : CommonResult.error("修改失败");
    }

    @ApiOperation("删除资讯文章")
    @PreAuthorize("@ss.hasPermi('yaman:news:remove')")
    @Log(title = "资讯文章", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public CommonResult remove(@PathVariable String id) {
        MryNews mryNews = newsService.selectById(id);
        if (mryNews == null) {
            return CommonResult.error("数据不存在");
        }
        mryNews.setDeleteFlag(1);
        return newsService.update(mryNews) > 0 ? CommonResult.ok("删除成功") : CommonResult.error("删除失败");

    }
}
