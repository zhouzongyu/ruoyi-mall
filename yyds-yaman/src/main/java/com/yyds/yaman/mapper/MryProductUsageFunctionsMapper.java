package com.yyds.yaman.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyds.yaman.domain.MryProductUsageFunctions;
import org.apache.ibatis.annotations.Param;

/**
 * 产品使用方法和功能说明Mapper接口
 *
 * @author zzy
 */
public interface MryProductUsageFunctionsMapper extends BaseMapper<MryProductUsageFunctions> {
    /**
     * 查询产品使用方法和功能说明列表
     *
     * @param mryProductUsageFunctions 产品使用方法和功能说明
     * @return 产品使用方法和功能说明集合
     */
    List<MryProductUsageFunctions> selectByEntity(MryProductUsageFunctions mryProductUsageFunctions);

    /**
     * 批量软删除
     *
     * @param ids
     * @return
     */
    int updateDelFlagByIds(@Param("ids" ) Long[] ids);
}
