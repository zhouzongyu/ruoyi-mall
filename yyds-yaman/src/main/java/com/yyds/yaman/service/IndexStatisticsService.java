package com.yyds.yaman.service;

import com.yyds.yaman.pojo.vo.DeviceStatisticsVO;
import org.springframework.stereotype.Service;

@Service
public class IndexStatisticsService {
    public DeviceStatisticsVO statisticsDevice() {
        DeviceStatisticsVO vo = new DeviceStatisticsVO();
        vo.setDeviceCount(1);
        vo.setDeviceFaultCount(0);
        vo.setDeviceBindCount(1);
        vo.setProductCount(1);
        return vo;
    }

}
