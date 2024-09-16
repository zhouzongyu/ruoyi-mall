package com.yyds.yaman.mapper;


import com.yyds.yaman.pojo.vo.StatisticsMemberActiveStatsVo;
import com.yyds.yaman.pojo.vo.StatisticsMemberVO;
import com.yyds.yaman.pojo.vo.StatisticsNewMemberVO;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zzy
 */
public interface IndexStatisticsMapper {
    List<StatisticsNewMemberVO> newMemberStatistics(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

    Integer totalDeviceStatistics();

    Integer totalProductStatistics();

    Integer totalDeviceBindStatistics();

    Integer totalMemberStatisticsByBirthDate(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

    List<StatisticsMemberVO> selectMemberStatisticsByArea();

    List<StatisticsMemberActiveStatsVo>  selectMemberActiveStatisticsByHour(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

    List<StatisticsMemberActiveStatsVo>  selectMemberActiveStatisticsByDay(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

}
