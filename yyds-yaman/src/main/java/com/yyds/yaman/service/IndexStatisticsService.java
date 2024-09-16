package com.yyds.yaman.service;

import com.ruoyi.common.utils.DateUtils;
import com.yyds.yaman.mapper.IndexStatisticsMapper;
import com.yyds.yaman.pojo.vo.StatisticsDeviceVO;
import com.yyds.yaman.pojo.vo.StatisticsMemberActiveStatsVo;
import com.yyds.yaman.pojo.vo.StatisticsMemberVO;
import com.yyds.yaman.pojo.vo.StatisticsNewMemberVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.ruoyi.common.utils.DateUtils.getDateTimeRange;

@Slf4j
@Service
public class IndexStatisticsService {

    @Autowired
    private IndexStatisticsMapper indexStatisticsMapper;

    public StatisticsDeviceVO statisticsDevice() {
        StatisticsDeviceVO vo = new StatisticsDeviceVO();
        vo.setDeviceCount(indexStatisticsMapper.totalDeviceStatistics());
        vo.setDeviceFaultCount(0);
        vo.setDeviceBindCount(indexStatisticsMapper.totalDeviceBindStatistics());
        vo.setProductCount(indexStatisticsMapper.totalProductStatistics());
        return vo;
    }

    /**
     * 按天和小时统计用户活跃数
     */
    public List<StatisticsMemberActiveStatsVo> statMemberActive(Integer type, String beginTime, String endTime) {
        if (type == 1) {
            //按小时
            return statMemberActiveByHour(beginTime);
        } else {
            //按天
            return statMemberActiveByDay(beginTime, endTime);

        }
    }


    private List<StatisticsMemberActiveStatsVo> statMemberActiveByHour(String date) {
        // 查询近一天数据，
        // 初始化24小时统计数据列表
        List<StatisticsMemberActiveStatsVo> activeStatsList = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            activeStatsList.add(new StatisticsMemberActiveStatsVo("" + i, 0));
        }
        // 查询数据库统计数据
        List<StatisticsMemberActiveStatsVo> statsFromDb = indexStatisticsMapper.selectMemberActiveStatisticsByHour(date, date);

        // 更新统计数据
        Map<String, Integer> dbCounts = statsFromDb.stream()
                .collect(Collectors.toMap(StatisticsMemberActiveStatsVo::getTime, StatisticsMemberActiveStatsVo::getCount));

        for (StatisticsMemberActiveStatsVo stat : activeStatsList) {
            String day = stat.getTime();
            Integer count = dbCounts.getOrDefault(day, 0);
            stat.setCount(count);
        }
        activeStatsList.stream().forEach(item->{
            item.setTime((Integer.valueOf(item.getTime()) < 10 ? "0" + item.getTime() : item.getTime()) +   ":00");
        });
        return activeStatsList;
    }

    private List<StatisticsMemberActiveStatsVo> statMemberActiveByDay(String beginTime, String endTime) {
        // 初始化统计数据列表
        List<String> dateTimeRange = getDateTimeRange(beginTime, endTime);
        List<StatisticsMemberActiveStatsVo> activeStatsList = dateTimeRange.stream().map(item -> {
            StatisticsMemberActiveStatsVo statsVo = new StatisticsMemberActiveStatsVo();
            statsVo.setCount(0);
            statsVo.setTime(item);
            return statsVo;
        }).collect(Collectors.toList());

        // 查询数据库统计数据
        List<StatisticsMemberActiveStatsVo> statsFromDb = indexStatisticsMapper.selectMemberActiveStatisticsByDay(beginTime, endTime);

        // 更新统计数据
        Map<String, Integer> dbCounts = statsFromDb.stream()
                .collect(Collectors.toMap(StatisticsMemberActiveStatsVo::getTime, StatisticsMemberActiveStatsVo::getCount));

        for (StatisticsMemberActiveStatsVo stat : activeStatsList) {
            String day = stat.getTime();
            Integer count = dbCounts.getOrDefault(day, 0);
            stat.setCount(count);
        }
        return activeStatsList;
    }

    /**
     * 按地区分布统计会员数
     *
     * @return
     */
    public List<StatisticsMemberVO> statMemberByArea() {
        return indexStatisticsMapper.selectMemberStatisticsByArea();
    }

    /**
     * 按年龄分布统计会员数
     *
     * @return
     */

    public List<StatisticsMemberVO> statMemberByAge() {
        // 0-18岁 19-35岁 36-50岁 51-65岁 65岁以上
        String[] ages = new String[]{"0-18", "19-35", "36-50", "51-65", "65"};
        List<StatisticsMemberVO> list = new ArrayList<>();

        for (int i = 0; i < ages.length; i++) {
            String age = ages[i];
            String[] ageRange = age.split("-");
            String endTime = DateUtils.parseDateToStr("yyyy-MM-dd", DateUtils.addYears(new Date(), -Integer.valueOf(ageRange[0])));

            StatisticsMemberVO statisticsMemberVO = new StatisticsMemberVO();
            if (i == ages.length - 1) {
                statisticsMemberVO.setName(age + "岁以上");
                statisticsMemberVO.setCount(indexStatisticsMapper.totalMemberStatisticsByBirthDate(null, endTime));
            } else {
                String startTime = DateUtils.parseDateToStr("yyyy-MM-dd", DateUtils.addYears(new Date(), -Integer.valueOf(ageRange[1])));

                log.info("beginTime:{} , endTime:{}", startTime, endTime);
                statisticsMemberVO.setName(age + "岁");
                statisticsMemberVO.setCount(indexStatisticsMapper.totalMemberStatisticsByBirthDate(startTime, endTime));
            }

            list.add(statisticsMemberVO);
        }
        return list;
    }

    public List<StatisticsNewMemberVO> newMemberStatistics(String beginTime, String endTime) {

        // 初始化统计数据列表
        List<String> dateTimeRange = getDateTimeRange(beginTime, endTime);
        List<StatisticsNewMemberVO> newMemberStats = dateTimeRange.stream().map(item -> {
            StatisticsNewMemberVO statisticsNewMemberVO = new StatisticsNewMemberVO();
            statisticsNewMemberVO.setCount(0);
            statisticsNewMemberVO.setDay(item);
            return statisticsNewMemberVO;
        }).collect(Collectors.toList());

        // 查询数据库统计数据
        List<StatisticsNewMemberVO> statsFromDb = indexStatisticsMapper.newMemberStatistics(beginTime, endTime);

        // 更新统计数据
        Map<String, Integer> dbCounts = statsFromDb.stream()
                .collect(Collectors.toMap(StatisticsNewMemberVO::getDay, StatisticsNewMemberVO::getCount));

        for (StatisticsNewMemberVO stat : newMemberStats) {
            String day = stat.getDay();
            Integer count = dbCounts.getOrDefault(day, 0);
            stat.setCount(count);
        }
        return newMemberStats;
    }


}
