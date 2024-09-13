package com.yyds.yaman.service;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.yyds.yaman.domain.MryMember;
import com.yyds.yaman.pojo.query.MryMemberQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.yyds.yaman.mapper.MryMemberMapper;

/**
 * 会员Service业务层处理
 *
 * @author zzy
 */
@Service
public class MryMemberService {
    @Autowired
    private MryMemberMapper mryMemberMapper;

    /**
     * 查询会员
     *
     * @param id 会员主键
     * @return 会员
     */
    public MryMember selectById(String id) {
        return mryMemberMapper.selectById(id);
    }

    /**
     * 查询会员列表
     *
     * @param query 查询条件
     * @param page  分页条件
     * @return 会员
     */
    public List<MryMember> selectList(MryMemberQuery query, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);

        QueryWrapper<MryMember> qw = new QueryWrapper<>();
        qw.lambda().eq(MryMember::getDeleteFlag, 0);
        String userNameLike = query.getUserName();
        if (!StringUtils.isEmpty(userNameLike)) {
            qw.like("user_name", userNameLike);
        }
        String phone = query.getPhone();
        if (!StringUtils.isEmpty(phone)) {
            qw.eq("phone", phone);
        }
        String vipNumber = query.getVipNumber();
        if (!StringUtils.isEmpty(vipNumber)) {
            qw.eq("vip_number", vipNumber);
        }
        return mryMemberMapper.selectList(qw);
    }

    /**
     * 新增会员
     *
     * @param mryMember 会员
     * @return 结果
     */
    public int insert(MryMember mryMember) {
        mryMember.setDeleteFlag(0);
        mryMember.setCreateTime(LocalDateTime.now());
        return mryMemberMapper.insert(mryMember);
    }

    /**
     * 修改会员
     *
     * @param mryMember 会员
     * @return 结果
     */
    public int update(MryMember mryMember) {
        return mryMemberMapper.updateById(mryMember);
    }

    /**
     * 批量删除会员
     *
     * @param ids 需要删除的会员主键
     * @return 结果
     */
    public int deleteByIds(String[] ids) {
        return mryMemberMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除会员信息
     *
     * @param id 会员主键
     * @return 结果
     */
    public int deleteUser(MryMember mryMember) {
        mryMember.setDeleteFlag(1);
        mryMember.setUpdateTime(LocalDateTime.now());
        return mryMemberMapper.updateById(mryMember);
    }
}
