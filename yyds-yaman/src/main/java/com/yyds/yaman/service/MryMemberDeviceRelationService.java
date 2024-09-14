package com.yyds.yaman.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyds.yaman.domain.MryMemberDeviceRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.yyds.yaman.mapper.MryMemberDeviceRelationMapper;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author zzy
 */
@Service
public class MryMemberDeviceRelationService {
    @Autowired
    private MryMemberDeviceRelationMapper mryMemberDeviceRelationMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public MryMemberDeviceRelation selectById(Integer id) {
        return mryMemberDeviceRelationMapper.selectById(id);
    }


    /**
     * 新增【请填写功能名称】
     *
     * @param mryMemberDeviceRelation 【请填写功能名称】
     * @return 结果
     */
    public int insert(MryMemberDeviceRelation mryMemberDeviceRelation) {
        return mryMemberDeviceRelationMapper.insert(mryMemberDeviceRelation);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param mryMemberDeviceRelation 【请填写功能名称】
     * @return 结果
     */
    public int update(MryMemberDeviceRelation mryMemberDeviceRelation) {
        return mryMemberDeviceRelationMapper.updateById(mryMemberDeviceRelation);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    public int deleteByIds(Integer[] ids) {
        return mryMemberDeviceRelationMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteById(Integer id) {
        return mryMemberDeviceRelationMapper.deleteById(id);
    }

    public int deleteByUserId(String userId) {
        if (StringUtils.isBlank(userId)) {
            return 0;
        }
        QueryWrapper<MryMemberDeviceRelation> qw = new QueryWrapper<>();
        qw.lambda().eq(MryMemberDeviceRelation::getUserId, userId);
        return mryMemberDeviceRelationMapper.delete(qw);
    }
}
