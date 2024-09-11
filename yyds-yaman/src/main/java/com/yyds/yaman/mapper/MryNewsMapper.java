package com.yyds.yaman.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyds.yaman.domain.MryNews;
import org.apache.ibatis.annotations.Param;

/**
 * 资讯文章Mapper接口
 * 
 * @author zzy
 */
public interface MryNewsMapper extends BaseMapper<MryNews> {
    /**
     * 查询资讯文章列表
     *
     * @param mryNews 资讯文章
     * @return 资讯文章集合
     */
    List<MryNews> selectByEntity(MryNews mryNews);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") String[] ids);
}
