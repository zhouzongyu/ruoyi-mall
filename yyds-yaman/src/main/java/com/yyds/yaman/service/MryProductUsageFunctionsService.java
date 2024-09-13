package com.yyds.yaman.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyds.yaman.domain.MryProductUsageFunctions;
import com.yyds.yaman.mapper.MryProductUsageFunctionsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MryProductUsageFunctionsService extends ServiceImpl<MryProductUsageFunctionsMapper, MryProductUsageFunctions> {
    public List<MryProductUsageFunctions> getUsageFunctionsByProductId(String productId) {
        QueryWrapper<MryProductUsageFunctions> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(MryProductUsageFunctions::getProductId, productId);
        return this.list(queryWrapper);
    }

    public int deleteProductUsageFunctionInfoByIdAndProductId(String productId, String id) {
        QueryWrapper<MryProductUsageFunctions> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(MryProductUsageFunctions::getProductId, productId).eq(MryProductUsageFunctions::getId, id);
        return this.baseMapper.delete(queryWrapper);
    }
}
