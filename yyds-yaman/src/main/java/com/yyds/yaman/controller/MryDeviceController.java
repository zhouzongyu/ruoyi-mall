package com.yyds.yaman.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.page.PageVo;
import com.yyds.yaman.domain.MryDeviceBindLog;
import com.yyds.yaman.pojo.query.MryDeviceBindLogQuery;
import com.yyds.yaman.pojo.query.MryDeviceUsageRecordQuery;
import com.yyds.yaman.pojo.query.MryMemberQuery;
import com.yyds.yaman.pojo.vo.MryDeviceBindLogVO;
import com.yyds.yaman.pojo.vo.MryDeviceUsageRecordVO;
import com.yyds.yaman.pojo.vo.MryFirmwareVO;
import com.yyds.yaman.pojo.vo.MryMemberVO;
import com.yyds.yaman.service.MryDeviceBindLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.enums.BusinessType;
import com.yyds.yaman.domain.MryDeviceUsageRecord;
import com.yyds.yaman.service.MryDeviceUsageRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 设备使用记录Controller
 *
 * @author zzy
 * @date 2024-09-11
 */
@Api(tags = "设备管理接口")
@RestController
@RequestMapping("/yaman/device")
public class MryDeviceController extends BaseController {
    @Autowired
    private MryDeviceUsageRecordService deviceUsageRecordService;

    @Autowired
    private MryDeviceBindLogService deviceBindLogService;

    @ApiOperation("查询设备使用记录")
    @GetMapping("/{deviceId}/getDeviceUsageRecords")
    public CommonResult<PageVo<MryDeviceUsageRecordVO>> usageRecords(
            @PathVariable("deviceId") String deviceId,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        MryDeviceUsageRecordQuery query = new MryDeviceUsageRecordQuery();
        query.setDeviceId(deviceId);
        List<MryDeviceUsageRecord> list = deviceUsageRecordService.selectList(query, pageNum, pageSize);
        List<MryDeviceUsageRecordVO> recordList = list.stream().map(item -> {
            MryDeviceUsageRecordVO recordVO = new MryDeviceUsageRecordVO();
            recordVO.setId(item.getId());
            recordVO.setDuration(item.getDuration());
            recordVO.setMode(item.getMode());
            recordVO.setGear(item.getGear());
            recordVO.setUsageTime(item.getUsageTime());
            return recordVO;
        }).collect(Collectors.toList());

        PageVo<MryDeviceUsageRecordVO> resultPage = new PageVo<MryDeviceUsageRecordVO>();
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

    @ApiOperation("查询设备绑定记录")
    @PreAuthorize("@ss.hasPermi('yaman:ban:list')")
    @GetMapping("/{deviceId}/getDeviceBindRecords")
    public CommonResult<PageVo<MryDeviceBindLogVO>> getDeviceBindRecords(
            @PathVariable("deviceId") String deviceId,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        MryDeviceBindLogQuery query = new MryDeviceBindLogQuery();
        query.setDeviceId(deviceId);
        List<MryDeviceBindLog> list = deviceBindLogService.selectList(query, pageNum, pageSize);
        List<MryDeviceBindLogVO> recordList = list.stream().map(item -> {
            MryDeviceBindLogVO recordVO = new MryDeviceBindLogVO();
            recordVO.setId(item.getId());
            recordVO.setCreateTime(item.getCreateTime());
            recordVO.setAction(item.getAction());
            recordVO.setUserName(item.getUserName());
            return recordVO;
        }).collect(Collectors.toList());

        PageVo<MryDeviceBindLogVO> resultPage = new PageVo<MryDeviceBindLogVO>();
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

}
