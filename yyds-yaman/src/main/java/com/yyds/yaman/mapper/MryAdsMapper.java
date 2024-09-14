package com.yyds.yaman.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyds.yaman.domain.MryAds;
import org.apache.ibatis.annotations.Param;

/**
 * 广告Mapper接口
 *
 * @author zzy
 */
public interface MryAdsMapper extends BaseMapper<MryAds> {
    /**
     * 查询广告列表
     *
     * @param mryAds 广告
     * @return 广告集合
     */
    List<MryAds> selectByEntity(MryAds mryAds);

    /**
     * 批量软删除
     *
     * @param ids
     * @return
     */
    int updateDelFlagByIds(@Param("ids") Integer[] ids);
}
