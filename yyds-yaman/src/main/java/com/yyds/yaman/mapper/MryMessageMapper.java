package com.yyds.yaman.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyds.yaman.domain.MryMessage;
import org.apache.ibatis.annotations.Param;

/**
 * 消息Mapper接口
 * 
 * @author zzy
 */
public interface MryMessageMapper extends BaseMapper<MryMessage> {
    /**
     * 查询消息列表
     *
     * @param mryMessage 消息
     * @return 消息集合
     */
    List<MryMessage> selectByEntity(MryMessage mryMessage);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Integer[] ids);
}
