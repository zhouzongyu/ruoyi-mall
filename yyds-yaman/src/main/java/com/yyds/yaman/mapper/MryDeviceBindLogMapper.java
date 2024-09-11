package com.yyds.yaman.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyds.yaman.domain.MryDeviceBindLog;
import org.apache.ibatis.annotations.Param;

/**
 * 设备绑定记录Mapper接口
 * 
 * @author zzy
 */
public interface MryDeviceBindLogMapper extends BaseMapper<MryDeviceBindLog> {
    /**
     * 查询设备绑定记录列表
     *
     * @param mryDeviceBindLog 设备绑定记录
     * @return 设备绑定记录集合
     */
    List<MryDeviceBindLog> selectByEntity(MryDeviceBindLog mryDeviceBindLog);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
