package com.yyds.yaman.service;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.yyds.yaman.domain.MryApplication;
import com.yyds.yaman.pojo.query.MryApplicationQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.yyds.yaman.mapper.MryApplicationMapper;

/**
 * 应用管理Service业务层处理
 *
 * @author zzy
 */
@Service
public class MryApplicationService {
    @Autowired
    private MryApplicationMapper mryApplicationMapper;

    /**
     * 查询应用管理
     *
     * @param id 应用管理主键
     * @return 应用管理
     */
    public MryApplication selectById(String id) {
        return mryApplicationMapper.selectById(id);
    }

    /**
     * 查询应用管理列表
     *
     * @param query 查询条件
     * @param page  分页条件
     * @return 应用管理
     */
    public List<MryApplication> selectList(MryApplicationQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<MryApplication> qw = new QueryWrapper<>();
        qw.eq("del_flag", 0);
        String appNameLike = query.getAppNameLike();
        if (!StringUtils.isEmpty(appNameLike)) {
            qw.like("app_name", appNameLike);
        }
        String iconUrl = query.getIconUrl();
        if (!StringUtils.isEmpty(iconUrl)) {
            qw.eq("icon_url", iconUrl);
        }
        String mpAppId = query.getMpAppId();
        if (!StringUtils.isEmpty(mpAppId)) {
            qw.eq("mp_app_id", mpAppId);
        }
        String mpAppSecret = query.getMpAppSecret();
        if (!StringUtils.isEmpty(mpAppSecret)) {
            qw.eq("mp_app_secret", mpAppSecret);
        }
        String miniProgramAppId = query.getMiniProgramAppId();
        if (!StringUtils.isEmpty(miniProgramAppId)) {
            qw.eq("mini_program_app_id", miniProgramAppId);
        }
        String miniProgramSecret = query.getMiniProgramSecret();
        if (!StringUtils.isEmpty(miniProgramSecret)) {
            qw.eq("mini_program_secret", miniProgramSecret);
        }
        return mryApplicationMapper.selectList(qw);
    }

    /**
     * 新增应用管理
     *
     * @param mryApplication 应用管理
     * @return 结果
     */
    public int insert(MryApplication mryApplication) {
        mryApplication.setCreateTime(LocalDateTime.now());
        return mryApplicationMapper.insert(mryApplication);
    }

    /**
     * 修改应用管理
     *
     * @param mryApplication 应用管理
     * @return 结果
     */
    public int update(MryApplication mryApplication) {
        return mryApplicationMapper.updateById(mryApplication);
    }

    /**
     * 批量删除应用管理
     *
     * @param ids 需要删除的应用管理主键
     * @return 结果
     */
    public int deleteByIds(String[] ids) {
        return mryApplicationMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除应用管理信息
     *
     * @param id 应用管理主键
     * @return 结果
     */
    public int deleteById(String id) {
        String[] ids = {id};
        return mryApplicationMapper.updateDelFlagByIds(ids);
    }
}
