package com.yyds.yaman.service;


 import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
 import com.yyds.yaman.domain.MryFirmware;
 import com.yyds.yaman.pojo.query.MryFirmwareQuery;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
     * @param page 分页条件
     * @return  固件版本
     */
    public List<MryFirmware> selectList(MryFirmwareQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<MryFirmware> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        String version = query.getVersion();
        if (!StringUtils.isEmpty(version)) {
            qw.eq("version", version);
        }
        String description = query.getDescription();
        if (!StringUtils.isEmpty(description)) {
            qw.eq("description", description);
        }
        String filePath = query.getFilePath();
        if (!StringUtils.isEmpty(filePath)) {
            qw.eq("file_path", filePath);
        }
        String fileNameLike = query.getFileNameLike();
        if (!StringUtils.isEmpty(fileNameLike)) {
            qw.like("file_name", fileNameLike);
        }
        String applicationId = query.getApplicationId();
        if (!StringUtils.isEmpty(applicationId)) {
            qw.eq("application_id", applicationId);
        }
        return mryFirmwareMapper.selectList(qw);
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
    public int deleteByIds(String[] ids) {
        return mryFirmwareMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除 固件版本信息
     *
     * @param id  固件版本主键
     * @return 结果
     */
    public int deleteById(String id) {
        String[] ids = {id};
        return mryFirmwareMapper.updateDelFlagByIds(ids);
    }
}
