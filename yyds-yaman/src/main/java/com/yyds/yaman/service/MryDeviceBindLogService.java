package com.yyds.yaman.service;


 import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
 import com.yyds.yaman.domain.MryDeviceBindLog;
 import com.yyds.yaman.pojo.query.MryDeviceBindLogQuery;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.yyds.yaman.mapper.MryDeviceBindLogMapper;

/**
 * 设备绑定记录Service业务层处理
 *
 *
 * @author zzy
 */
@Service
public class MryDeviceBindLogService {
    @Autowired
    private MryDeviceBindLogMapper mryDeviceBindLogMapper;
    /**
     * 查询设备绑定记录
     *
     * @param id 设备绑定记录主键
     * @return 设备绑定记录
     */
    public MryDeviceBindLog selectById(String id) {
        return mryDeviceBindLogMapper.selectById(id);
    }

    /**
     * 查询设备绑定记录列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 设备绑定记录
     */
    public List<MryDeviceBindLog> selectList(MryDeviceBindLogQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<MryDeviceBindLog> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        String deviceId = query.getDeviceId();
        if (!StringUtils.isEmpty(deviceId)) {
            qw.eq("device_id", deviceId);
        }
        Integer action = query.getAction();
        if (action != null) {
            qw.eq("action", action);
        }
        String userId = query.getUserId();
        if (!StringUtils.isEmpty(userId)) {
            qw.eq("user_id", userId);
        }
        String userNameLike = query.getUserNameLike();
        if (!StringUtils.isEmpty(userNameLike)) {
            qw.like("user_name", userNameLike);
        }
        return mryDeviceBindLogMapper.selectList(qw);
    }

    /**
     * 新增设备绑定记录
     *
     * @param mryDeviceBindLog 设备绑定记录
     * @return 结果
     */
    public int insert(MryDeviceBindLog mryDeviceBindLog) {
        mryDeviceBindLog.setCreateTime(LocalDateTime.now());
        return mryDeviceBindLogMapper.insert(mryDeviceBindLog);
    }

    /**
     * 修改设备绑定记录
     *
     * @param mryDeviceBindLog 设备绑定记录
     * @return 结果
     */
    public int update(MryDeviceBindLog mryDeviceBindLog) {
        return mryDeviceBindLogMapper.updateById(mryDeviceBindLog);
    }

    /**
     * 批量删除设备绑定记录
     *
     * @param ids 需要删除的设备绑定记录主键
     * @return 结果
     */
    public int deleteByIds(Long[] ids) {
        return mryDeviceBindLogMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除设备绑定记录信息
     *
     * @param id 设备绑定记录主键
     * @return 结果
     */
    public int deleteById(Long id) {
        Long[] ids = {id};
        return mryDeviceBindLogMapper.updateDelFlagByIds(ids);
    }
}
