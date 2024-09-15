package com.yyds.yaman.service;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.yyds.yaman.domain.MryAds;
import com.yyds.yaman.pojo.query.MryAdsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.yyds.yaman.mapper.MryAdsMapper;

/**
 * 推广链接Service业务层处理
 *
 * @author zzy
 */
@Service
public class MryAdsService {
    @Autowired
    private MryAdsMapper mryAdsMapper;

    /**
     * 查询推广链接
     *
     * @param id 推广链接主键
     * @return 推广链接
     */
    public MryAds selectById(Integer id) {
        return mryAdsMapper.selectById(id);
    }

    /**
     * 查询推广链接列表
     *
     * @param query 查询条件
     * @return 推广链接
     */
    public List<MryAds> selectList(MryAdsQuery query, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        QueryWrapper<MryAds> qw = new QueryWrapper<>();
        qw.lambda().eq(MryAds::getDeleteFlag, 0);

        return mryAdsMapper.selectList(qw);
    }

    /**
     * 新增推广链接
     *
     * @param mryAds 推广链接
     * @return 结果
     */
    public int insert(MryAds mryAds) {
        mryAds.setDeleteFlag(0);
        mryAds.setCreateTime(LocalDateTime.now());
        return mryAdsMapper.insert(mryAds);
    }

    /**
     * 修改推广链接
     *
     * @param mryAds 推广链接
     * @return 结果
     */
    public int update(MryAds mryAds) {
        return mryAdsMapper.updateById(mryAds);
    }

    /**
     * 批量删除推广链接
     *
     * @param ids 需要删除的推广链接主键
     * @return 结果
     */
    public int deleteById(Integer id) {
        return mryAdsMapper.deleteById(id);
    }

}
