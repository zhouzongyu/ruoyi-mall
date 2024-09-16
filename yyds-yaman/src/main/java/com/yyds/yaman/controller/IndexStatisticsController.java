package com.yyds.yaman.controller;

import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.yyds.yaman.pojo.query.StatsActiveUserStatisticsQuery;
import com.yyds.yaman.pojo.vo.StatisticsDeviceVO;
import com.yyds.yaman.pojo.vo.StatisticsMemberActiveStatsVo;
import com.yyds.yaman.pojo.vo.StatisticsMemberVO;
import com.yyds.yaman.pojo.vo.StatisticsNewMemberVO;
import com.yyds.yaman.service.IndexStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "数据看板")
@Slf4j
@RestController
@RequestMapping("/statistics/index")
public class IndexStatisticsController {

    @Autowired
    private IndexStatisticsService indexStatisticsService;


    @ApiOperation(value = "会员数-年龄分布")
    @GetMapping("/member/statMemberByAge")
    public CommonResult<List<StatisticsMemberVO>> statMemberByAge(){
        return CommonResult.data(indexStatisticsService.statMemberByAge());
    }

    @ApiOperation(value = "会员数-地域分布")
    @GetMapping("/member/statMemberByArea")
    public CommonResult<List<StatisticsMemberVO>> statMemberByArea(){
        return CommonResult.data(indexStatisticsService.statMemberByArea());
    }

    @ApiOperation(value = "新增用户统计")
    @GetMapping("/member/newUserStatistics")
    public CommonResult<List<StatisticsNewMemberVO>> newUserStatistics( @RequestParam(value = "beginTime", defaultValue = "", required = true) String beginTime,
                                           @RequestParam(value = "endTime", defaultValue = "", required = true) String endTime){

        return CommonResult.data(indexStatisticsService.newMemberStatistics(beginTime, endTime));
    }

    @ApiOperation(value = "活动用户统计")
    @GetMapping("/member/activeUserStatistics")
    public CommonResult<List<StatisticsMemberActiveStatsVo>> activeUserStatistics(@Validated StatsActiveUserStatisticsQuery statsActiveUserStatisticsQuery){

        if(StringUtils.isEmpty(statsActiveUserStatisticsQuery.getBeginTime())) {
            statsActiveUserStatisticsQuery.setBeginTime(DateUtils.getDate());
        }
        if(StringUtils.isEmpty(statsActiveUserStatisticsQuery.getEndTime())) {
            statsActiveUserStatisticsQuery.setEndTime(DateUtils.getDate());
        }

        return CommonResult.data(indexStatisticsService.statMemberActive(statsActiveUserStatisticsQuery.getType(), statsActiveUserStatisticsQuery.getBeginTime(), statsActiveUserStatisticsQuery.getEndTime()));
    }


    @ApiOperation(value = "设备产品数")
    @GetMapping("/deviceAndProduct/statistics")
    public CommonResult<StatisticsDeviceVO> deviceStatistics(){
        return CommonResult.data(indexStatisticsService.statisticsDevice());
    }
}
