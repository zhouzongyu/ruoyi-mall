package com.yyds.yaman.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyds.yaman.domain.MryFirmware;
import org.apache.ibatis.annotations.Param;

/**
 *  固件版本Mapper接口
 * 
 * @author zzy
 */
public interface MryFirmwareMapper extends BaseMapper<MryFirmware> {
    /**
     * 查询 固件版本列表
     *
     * @param mryFirmware  固件版本
     * @return  固件版本集合
     */
    List<MryFirmware> selectByEntity(MryFirmware mryFirmware);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
