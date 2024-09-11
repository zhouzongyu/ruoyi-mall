package com.yyds.yaman.service;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.yyds.yaman.domain.MryApplication;
import com.yyds.yaman.pojo.query.MryApplicationQuery;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class MryApplicationService {
    @Autowired
    private MryApplicationMapper mryApplicationMapper;

    public MryApplication queryApplicationSetting() {
        QueryWrapper<MryApplication> queryWrapper = new QueryWrapper<>();
        return mryApplicationMapper.selectOne(queryWrapper);
    }

    public int updateApplicationSetting(MryApplication mryApplication) {
        return mryApplicationMapper.updateById(mryApplication);
    }

}
