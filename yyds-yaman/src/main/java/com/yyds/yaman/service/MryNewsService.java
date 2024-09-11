package com.yyds.yaman.service;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.yyds.yaman.domain.MryNews;
import com.yyds.yaman.pojo.query.MryNewsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
     * @param page  分页条件
     * @return 资讯文章
     */
    public List<MryNews> selectList(MryNewsQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<MryNews> qw = new QueryWrapper<>();
        qw.eq("del_flag", 0);
        String title = query.getTitle();
        if (!StringUtils.isEmpty(title)) {
            qw.eq("title", title);
        }
        String content = query.getContent();
        if (!StringUtils.isEmpty(content)) {
            qw.eq("content", content);
        }
        Integer sortNo = query.getSortNo();
        if (sortNo != null) {
            qw.eq("sort_no", sortNo);
        }
        String picUrl = query.getPicUrl();
        if (!StringUtils.isEmpty(picUrl)) {
            qw.eq("pic_url", picUrl);
        }
        String videoUrl = query.getVideoUrl();
        if (!StringUtils.isEmpty(videoUrl)) {
            qw.eq("video_url", videoUrl);
        }
        Integer deleteFlag = query.getDeleteFlag();
        if (deleteFlag != null) {
            qw.eq("delete_flag", deleteFlag);
        }
        Integer clickCount = query.getClickCount();
        if (clickCount != null) {
            qw.eq("click_count", clickCount);
        }
        Integer zanCount = query.getZanCount();
        if (zanCount != null) {
            qw.eq("zan_count", zanCount);
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
