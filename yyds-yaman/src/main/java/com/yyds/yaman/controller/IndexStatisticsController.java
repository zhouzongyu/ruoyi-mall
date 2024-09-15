package com.yyds.yaman.controller;

import com.ruoyi.common.core.domain.CommonResult;
import com.yyds.yaman.pojo.vo.DeviceStatisticsVO;
import com.yyds.yaman.pojo.vo.MemberStatisticsVO;
import com.yyds.yaman.service.IndexStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("数据看板")
@Slf4j
@RequestMapping("/statistics/index")
public class IndexStatisticsController {

    @Autowired
    private IndexStatisticsService indexStatisticsService;


    @ApiOperation(value = "会员数-年龄分布")
    @GetMapping("/member/statistics")
    public CommonResult<List<MemberStatisticsVO>> statMemberByAge(){
        return CommonResult.ok();
    }

    @ApiOperation(value = "会员数-地域分布")
    @GetMapping("/member/statistics")
    public CommonResult<MemberStatisticsVO> statMemberByArea(){
        return CommonResult.ok();
    }

    @ApiOperation(value = "新增用户统计")
    @GetMapping("/member/newUserStatistics")
    public CommonResult newUserStatistics(){
        return CommonResult.ok();
    }
    @ApiOperation(value = "活动用户统计")
    @GetMapping("/member/activeUserStatistics")
    public CommonResult activeUserStatistics(){
        return CommonResult.ok();
    }

    @ApiOperation(value = "设备产品数")
    @GetMapping("/deviceAndProduct/statistics")
    public CommonResult<DeviceStatisticsVO> deviceStatistics(){
        return CommonResult.data(indexStatisticsService.statisticsDevice());
    }
}
