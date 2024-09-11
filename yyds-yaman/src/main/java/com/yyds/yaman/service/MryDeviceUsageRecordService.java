package com.yyds.yaman.service;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.yyds.yaman.domain.MryDeviceUsageRecord;
import com.yyds.yaman.pojo.query.MryDeviceUsageRecordQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.yyds.yaman.mapper.MryDeviceUsageRecordMapper;

/**
 * 设备使用记录Service业务层处理
 *
 * @author zzy
 */
@Service
public class MryDeviceUsageRecordService {
    @Autowired
    private MryDeviceUsageRecordMapper mryDeviceUsageRecordMapper;

    /**
     * 查询设备使用记录
     *
     * @param id 设备使用记录主键
     * @return 设备使用记录
     */
    public MryDeviceUsageRecord selectById(Integer id) {
        return mryDeviceUsageRecordMapper.selectById(id);
    }

    /**
     * 查询设备使用记录列表
     *
     * @param query 查询条件
     * @param page  分页条件
     * @return 设备使用记录
     */
    public List<MryDeviceUsageRecord> selectList(MryDeviceUsageRecordQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<MryDeviceUsageRecord> qw = new QueryWrapper<>();
        return mryDeviceUsageRecordMapper.selectList(qw);
    }

    /**
     * 新增设备使用记录
     *
     * @param mryDeviceUsageRecord 设备使用记录
     * @return 结果
     */
    public int insert(MryDeviceUsageRecord mryDeviceUsageRecord) {
        return mryDeviceUsageRecordMapper.insert(mryDeviceUsageRecord);
    }

    /**
     * 修改设备使用记录
     *
     * @param mryDeviceUsageRecord 设备使用记录
     * @return 结果
     */
    public int update(MryDeviceUsageRecord mryDeviceUsageRecord) {
        return mryDeviceUsageRecordMapper.updateById(mryDeviceUsageRecord);
    }

    /**
     * 批量删除设备使用记录
     *
     * @param ids 需要删除的设备使用记录主键
     * @return 结果
     */
    public int deleteByIds(Long[] ids) {
        return mryDeviceUsageRecordMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除设备使用记录信息
     *
     * @param id 设备使用记录主键
     * @return 结果
     */
    public int deleteById(Long id) {
        Long[] ids = {id};
        return mryDeviceUsageRecordMapper.updateDelFlagByIds(ids);
    }
}
