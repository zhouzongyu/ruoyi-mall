package com.yyds.yaman.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.exception.ServiceException;
import com.yyds.yaman.domain.MryNews;
import com.yyds.yaman.pojo.query.MryNewsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.yyds.yaman.mapper.MryNewsMapper;

/**
 * 资讯文章Service业务层处理
 *
 * @author zzy
 */
@Service
public class MryNewsService {
    @Autowired
    private MryNewsMapper mryNewsMapper;

    /**
     * 查询资讯文章
     *
     * @param id 资讯文章主键
     * @return 资讯文章
     */
    public MryNews selectById(String id) {
        return mryNewsMapper.selectById(id);
    }

    /**
     * 查询资讯文章列表
     *
     * @param query 查询条件
     * @param pageNum  分页条件
     * @return 资讯文章
     */
    public List<MryNews> selectList(MryNewsQuery query, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<MryNews> qw = new QueryWrapper<>();
        qw.lambda().eq(MryNews::getDeleteFlag, 0);
        String title = query.getTitle();
        if (!StringUtils.isEmpty(title)) {
            qw.like("title", title);
        }

        if (query.getStartTime() != null && query.getEndTime() != null) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime startTime = LocalDateTime.parse(query.getStartTime()  + " 00:00:00", formatter);
                LocalDateTime endTime = LocalDateTime.parse(query.getEndTime()  + " 23:59:59", formatter);
                qw.between("create_time", startTime, endTime);
            } catch (Exception exception) {
                throw new ServiceException("时间格式参数错误");
            }

        }
        return mryNewsMapper.selectList(qw);
    }

    /**
     * 新增资讯文章
     *
     * @param mryNews 资讯文章
     * @return 结果
     */
    public int insert(MryNews mryNews) {
        mryNews.setDeleteFlag(0);
        mryNews.setCreateTime(LocalDateTime.now());
        return mryNewsMapper.insert(mryNews);
    }

    /**
     * 修改资讯文章
     *
     * @param mryNews 资讯文章
     * @return 结果
     */
    public int update(MryNews mryNews) {
        return mryNewsMapper.updateById(mryNews);
    }

    /**
     * 批量删除资讯文章
     *
     * @param ids 需要删除的资讯文章主键
     * @return 结果
     */
    public int deleteByIds(String[] ids) {
        return mryNewsMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除资讯文章信息
     *
     * @param id 资讯文章主键
     * @return 结果
     */
    public int deleteById(String id) {
        String[] ids = {id};
        return mryNewsMapper.updateDelFlagByIds(ids);
    }
}
