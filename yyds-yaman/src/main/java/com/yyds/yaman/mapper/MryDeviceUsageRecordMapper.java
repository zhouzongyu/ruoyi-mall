package com.yyds.yaman.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyds.yaman.domain.MryDeviceUsageRecord;
import org.apache.ibatis.annotations.Param;

/**
 * 设备使用记录Mapper接口
 * 
 * @author zzy
 */
public interface MryDeviceUsageRecordMapper extends BaseMapper<MryDeviceUsageRecord> {
    /**
     * 查询设备使用记录列表
     *
     * @param mryDeviceUsageRecord 设备使用记录
     * @return 设备使用记录集合
     */
    List<MryDeviceUsageRecord> selectByEntity(MryDeviceUsageRecord mryDeviceUsageRecord);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
