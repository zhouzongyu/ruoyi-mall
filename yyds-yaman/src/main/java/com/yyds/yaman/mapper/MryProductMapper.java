package com.yyds.yaman.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyds.yaman.domain.MryProduct;
import org.apache.ibatis.annotations.Param;

/**
 * 产品管理Mapper接口
 * 
 * @author zzy
 */
public interface MryProductMapper extends BaseMapper<MryProduct> {
    /**
     * 查询产品管理列表
     *
     * @param mryProduct 产品管理
     * @return 产品管理集合
     */
    List<MryProduct> selectByEntity(MryProduct mryProduct);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") String[] ids);
}
