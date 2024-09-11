package com.yyds.yaman.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyds.yaman.domain.MryApplication;
import org.apache.ibatis.annotations.Param;

/**
 * 应用管理Mapper接口
 * 
 * @author zzy
 */
public interface MryApplicationMapper extends BaseMapper<MryApplication> {
    /**
     * 查询应用管理列表
     *
     * @param mryApplication 应用管理
     * @return 应用管理集合
     */
    List<MryApplication> selectByEntity(MryApplication mryApplication);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") String[] ids);
}
