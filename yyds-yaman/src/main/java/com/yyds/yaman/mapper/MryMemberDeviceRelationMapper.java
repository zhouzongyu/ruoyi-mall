package com.yyds.yaman.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyds.yaman.domain.MryMemberDeviceRelation;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

/**
 * 用户设备关系Mapper接口
 * 
 * @author zzy
 */
public interface MryMemberDeviceRelationMapper extends BaseMapper<MryMemberDeviceRelation> {
    /**
     * 查询用户设备关系列表
     *
     * @param mryMemberDeviceRelation 用户设备关系
     * @return 用户设备关系集合
     */
    List<MryMemberDeviceRelation> selectByEntity(MryMemberDeviceRelation mryMemberDeviceRelation);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Integer[] ids);
}
