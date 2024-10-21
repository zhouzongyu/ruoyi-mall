package com.yyds.yaman.service;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.exception.ServiceException;
import com.yyds.yaman.domain.MryMember;
import com.yyds.yaman.pojo.query.MryMemberQuery;
import com.yyds.yaman.pojo.vo.MryMemberDetailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.yyds.yaman.mapper.MryMemberMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员Service业务层处理
 *
 * @author zzy
 */
@Service
public class MryMemberService {
    @Autowired
    private MryMemberMapper mryMemberMapper;

    @Autowired
    private MryDeviceService deviceService;

    @Autowired
    private MryMemberDeviceRelationService memberDeviceRelationService;

    /**
     * 查询会员
     *
     * @param id 会员主键
     * @return 会员
     */
    public MryMember selectById(String id) {
        return mryMemberMapper.selectById(id);
    }
    public MryMemberDetailVo getUserInfo(String id) {
        MryMember mryMember = selectById(id);
        if((mryMember == null)) {
            throw new ServiceException("会员不存在");
        }
        MryMemberDetailVo mryMemberDetailVo = new MryMemberDetailVo();
        mryMemberDetailVo.setId(mryMember.getId());
        mryMemberDetailVo.setUserName(mryMember.getUserName());
        mryMemberDetailVo.setBirthDate(mryMember.getBirthDate());
        mryMemberDetailVo.setGender(mryMember.getGender());
        mryMemberDetailVo.setAddress(mryMember.getAddress());
        mryMemberDetailVo.setPhone(mryMember.getPhone());
        mryMemberDetailVo.setVipNumber(mryMember.getVipNumber());
        mryMemberDetailVo.setRemark(mryMember.getRemark());
        mryMemberDetailVo.setDevices(deviceService.selectDeviceDetailListByUserId(mryMember.getId()));

        return mryMemberDetailVo;
    }

    /**
     * 查询会员列表
     *
     * @param pageNo 查询条件
     * @return 会员
     */
    public List<MryMember> selectList(MryMemberQuery query, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return mryMemberMapper.queryUserList(query);
    }

    public List<MryMember> selectList(MryMemberQuery query) {
        return mryMemberMapper.queryUserList(query);
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
     * @return 结果
     */
    @Transactional
    public int deleteUser(MryMember mryMember) {
        mryMember.setDeleteFlag(1);
        mryMember.setUpdateTime(LocalDateTime.now());
        if(mryMemberMapper.updateById(mryMember)> 0) {
            //删除设备
            return memberDeviceRelationService.deleteByUserId(mryMember.getId());
        }
        return 1;
    }

    public MryMember getByVipNumber(String vipNumber) {
        QueryWrapper<MryMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("vip_number", vipNumber);
        return mryMemberMapper.selectOne(queryWrapper);
    }

    public List<MryMember> getMemberListByAreaIds(List<String> areaIds){
        QueryWrapper<MryMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(MryMember::getDeleteFlag, 0).in(MryMember::getProvince, areaIds);
        return mryMemberMapper.selectList(queryWrapper);
    }

    public List<MryMember> getMemberList(){
        QueryWrapper<MryMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(MryMember::getDeleteFlag, 0);
        return mryMemberMapper.selectList(queryWrapper);
    }
}
