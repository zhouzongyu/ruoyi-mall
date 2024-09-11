package com.yyds.yaman.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.yyds.yaman.domain.MryProduct;
import com.yyds.yaman.mapper.MryProductMapper;
import com.yyds.yaman.pojo.query.MryProductQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


/**
 * 产品管理Service业务层处理
 *
 *
 * @author zzy
 */
@Service
public class MryProductService {
    @Autowired
    private MryProductMapper mryProductMapper;

    /**
     * 查询产品管理
     *
     * @param id 产品管理主键
     * @return 产品管理
     */
    public MryProduct selectById(String id) {
        return mryProductMapper.selectById(id);
    }

    /**
     * 查询产品管理列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 产品管理
     */
    public List<MryProduct> selectList(MryProductQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<MryProduct> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        String nameLike = query.getName();
        if (!StringUtils.isEmpty(nameLike)) {
            qw.like("name", nameLike);
        }
        Integer type = query.getType();
        if (type != null) {
            qw.eq("type", type);
        }

        return mryProductMapper.selectList(qw);
    }

    /**
     * 新增产品管理
     *
     * @param mryProduct 产品管理
     * @return 结果
     */
    public int insert(MryProduct mryProduct) {
        mryProduct.setDeleteFlag(0);
        mryProduct.setCreateTime(LocalDateTime.now());
        return mryProductMapper.insert(mryProduct);
    }

    /**
     * 修改产品管理
     *
     * @param mryProduct 产品管理
     * @return 结果
     */
    public int update(MryProduct mryProduct) {
        return mryProductMapper.updateById(mryProduct);
    }

    /**
     * 批量删除产品管理
     *
     * @param ids 需要删除的产品管理主键
     * @return 结果
     */
    public int deleteByIds(String[] ids) {
        return mryProductMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除产品管理信息
     *
     * @param id 产品管理主键
     * @return 结果
     */
    public int deleteById(String id) {
        String[] ids = {id};
        return mryProductMapper.updateDelFlagByIds(ids);
    }
}
