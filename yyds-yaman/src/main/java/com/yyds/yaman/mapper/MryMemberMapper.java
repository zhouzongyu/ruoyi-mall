package com.yyds.yaman.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyds.yaman.domain.MryMember;
import com.yyds.yaman.pojo.query.MryMemberQuery;
import org.apache.ibatis.annotations.Param;

/**
 * 会员Mapper接口
 * 
 * @author zzy
 */
public interface MryMemberMapper extends BaseMapper<MryMember> {
    /**
     * 查询会员列表
     *
     * @param mryMember 会员
     * @return 会员集合
     */
    List<MryMember> selectByEntity(MryMember mryMember);

    List<MryMember> queryUserList(MryMemberQuery query);
    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") String[] ids);
}
