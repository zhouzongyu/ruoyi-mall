package com.yyds.yaman.service;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.yyds.yaman.domain.MryDevice;
import com.yyds.yaman.pojo.dto.MryDeviceDTO;
import com.yyds.yaman.pojo.query.MryDeviceQuery;
import com.yyds.yaman.pojo.vo.MryMemberDeviceDetailVo;
import com.yyds.yaman.pojo.vo.MryMemberDeviceVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.yyds.yaman.mapper.MryDeviceMapper;

/**
 * @author zzy
 */
@Service
public class MryDeviceService {
    @Autowired
    private MryDeviceMapper mryDeviceMapper;

    /**
     * 查询设备信息
     *
     * @param id 设备信息主键
     * @return 设备信息
     */
    public MryDevice selectById(String id) {
        return mryDeviceMapper.selectById(id);
    }

    /**
     * @param query 查询条件
     * @param page  分页条件
     */
    public List<MryDevice> selectList(MryDeviceQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<MryDevice> qw = new QueryWrapper<>();
        String sn = query.getSn();
        if (!StringUtils.isEmpty(sn)) {
            qw.eq("sn", sn);
        }
        String model = query.getModel();
        if (!StringUtils.isEmpty(model)) {
            qw.eq("model", model);
        }
        String productId = query.getProductId();
        if (!StringUtils.isEmpty(productId)) {
            qw.eq("product_id", productId);
        }
        String usgeProvice = query.getUsgeProvice();
        if (!StringUtils.isEmpty(usgeProvice)) {
            qw.eq("usge_provice", usgeProvice);
        }
        String usgeCity = query.getUsgeCity();
        if (!StringUtils.isEmpty(usgeCity)) {
            qw.eq("usge_city", usgeCity);
        }
        String usgeArea = query.getUsgeArea();
        if (!StringUtils.isEmpty(usgeArea)) {
            qw.eq("usge_area", usgeArea);
        }
        return mryDeviceMapper.selectList(qw);
    }

    /**
     * 新增设备信息
     *
     * @param mryDevice 设备信息
     * @return 结果
     */
    public int insert(MryDevice mryDevice) {
        mryDevice.setCreateTime(LocalDateTime.now());
        return mryDeviceMapper.insert(mryDevice);
    }

    /**
     * 修改设备信息
     *
     * @param mryDevice 设备信息
     * @return 结果
     */
    public int update(MryDevice mryDevice) {
        return mryDeviceMapper.updateById(mryDevice);
    }

    /**
     * 批量删除设备信息
     *
     * @param ids 需要删除的设备信息主键
     * @return 结果
     */
    public int deleteByIds(String[] ids) {
        return mryDeviceMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除设备信息信息
     *
     * @param id 设备信息主键
     * @return 结果
     */
    public int deleteById(String id) {
        return mryDeviceMapper.deleteById(id);
    }

    public List<MryMemberDeviceVo> getDeviceListByUserId(String userId){
        return mryDeviceMapper.selectDeviceListByUserId(userId);
    }
    public List<MryDeviceDTO> getDeviceListByUserIds(List<String> userIds){
        return mryDeviceMapper.selectDeviceListByUserIds(userIds);
    }

    public List<MryMemberDeviceDetailVo> selectDeviceDetailListByUserId(String userId){
        return mryDeviceMapper.selectDeviceDetailListByUserId(userId);

    }

}
