package com.yyds.yaman.controller;

import java.util.List;

import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.page.PageVo;
import com.yyds.yaman.pojo.query.MryDeviceUsageRecordQuery;
import com.yyds.yaman.pojo.query.MryMemberQuery;
import com.yyds.yaman.pojo.vo.MryDeviceBindLogVO;
import com.yyds.yaman.pojo.vo.MryDeviceUsageRecordVO;
import com.yyds.yaman.pojo.vo.MryMemberVO;
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
@Api(tags ="设备管理接口")
@RestController
@RequestMapping("/yaman/device")
public class MryDeviceController extends BaseController {
    @Autowired
    private MryDeviceUsageRecordService service;


    @ApiOperation("查询设备使用记录" )
    @GetMapping("/getDeviceUsageRecords" )
    public CommonResult<PageVo<MryDeviceUsageRecordVO>> usageRecords(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                                     @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        //  List<MryMember> list = service.selectList(query, page);
        return CommonResult.ok();
    }
    @ApiOperation("查询设备绑定记录" )
    @PreAuthorize("@ss.hasPermi('yaman:ban:list')" )
    @GetMapping("/getDeviceBindRecords" )
    public CommonResult<PageVo<MryDeviceBindLogVO>> getDeviceBindRecords(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                                         @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        //  List<MryMember> list = service.selectList(query, page);
        return CommonResult.ok();
    }

}
