package com.yyds.yaman.service;


 import java.time.LocalDateTime;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
 import com.ruoyi.common.utils.HumpNamedUtils;
 import com.yyds.yaman.domain.MryFirmware;
 import com.yyds.yaman.pojo.query.MryFirmwareQuery;
 import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.yyds.yaman.mapper.MryFirmwareMapper;

/**
 *  固件版本Service业务层处理
 *
 *
 * @author zzy
 */
@Service
public class MryFirmwareService {
    @Autowired
    private MryFirmwareMapper mryFirmwareMapper;
    /**
     * 查询 固件版本
     *
     * @param id  固件版本主键
     * @return  固件版本
     */
    public MryFirmware selectById(Integer id) {
        return mryFirmwareMapper.selectById(id);
    }

    /**
     * 查询 固件版本列表
     *
     * @param query 查询条件
     * @return  固件版本
     */
    public List<MryFirmware> selectList(MryFirmwareQuery query, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<MryFirmware> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isEmpty(query.getColumn())){
            queryWrapper.orderByDesc("create_time");
        }
        //处理排序 升序
        if (StringUtils.isNotBlank(query.getColumn()) && query.getAsc()) {
            queryWrapper.orderByAsc(HumpNamedUtils.hump2LowerColumnName(query.getColumn()));
        }
        //处理排序 降序
        if (StringUtils.isNotBlank(query.getColumn()) && !query.getAsc()) {
            queryWrapper.orderByDesc(HumpNamedUtils.hump2LowerColumnName(query.getColumn()));
        }

        return mryFirmwareMapper.selectList(queryWrapper);
    }

    /**
     * 新增 固件版本
     *
     * @param mryFirmware  固件版本
     * @return 结果
     */
    public int insert(MryFirmware mryFirmware) {
        mryFirmware.setCreateTime(LocalDateTime.now());
        return mryFirmwareMapper.insert(mryFirmware);
    }

    /**
     * 修改 固件版本
     *
     * @param mryFirmware  固件版本
     * @return 结果
     */
    public int update(MryFirmware mryFirmware) {
        return mryFirmwareMapper.updateById(mryFirmware);
    }

    /**
     * 批量删除 固件版本
     *
     * @param ids 需要删除的 固件版本主键
     * @return 结果
     */
    public int deleteByIds(Long[] ids) {
        return mryFirmwareMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除 固件版本信息
     *
     * @param id  固件版本主键
     * @return 结果
     */
    public int deleteById(Integer id) {
        return mryFirmwareMapper.deleteById(id);
    }
}
