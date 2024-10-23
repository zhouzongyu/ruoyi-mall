package com.yyds.yaman.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.HumpNamedUtils;
import com.yyds.yaman.domain.MryProduct;
import com.yyds.yaman.domain.MryProductUsageFunctions;
import com.yyds.yaman.mapper.MryProductMapper;
import com.yyds.yaman.pojo.query.MryProductAddParam;
import com.yyds.yaman.pojo.query.MryProductEditParam;
import com.yyds.yaman.pojo.query.MryProductQuery;
import com.yyds.yaman.pojo.query.MryProductUsageFunctionAddParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 产品管理Service业务层处理
 *
 * @author zzy
 */
@Service
public class MryProductService {
    @Autowired
    private MryProductMapper mryProductMapper;

    @Autowired
    private MryProductUsageFunctionsService mryProductUsageFunctionsService;

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
     * @param pageSize  分页条件
     * @return 产品管理
     */
    public List<MryProduct> selectList(MryProductQuery query, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<MryProduct> qw = new QueryWrapper<>();
        qw.lambda().eq(MryProduct::getDeleteFlag, 0);
        String nameLike = query.getName();
        if (!StringUtils.isEmpty(nameLike)) {
            qw.like("name", nameLike);
        }
        String model = query.getModel();
        if (model != null) {
            qw.like("model", model);
        }
        Integer type = query.getType();
        if (type != null) {
            qw.eq("type", type);
        }
        if (StringUtils.isEmpty(query.getColumn())){
            qw.orderByDesc("create_time");
        }

        //处理排序 升序
        if (StringUtils.isNotBlank(query.getColumn()) && query.getAsc()) {
            qw.orderByAsc(HumpNamedUtils.hump2LowerColumnName(query.getColumn()));
        }
        //处理排序 降序
        if (StringUtils.isNotBlank(query.getColumn()) && !query.getAsc()) {
            qw.orderByDesc(HumpNamedUtils.hump2LowerColumnName(query.getColumn()));
        }
        return mryProductMapper.selectList(qw);
    }

    @Transactional
    public CommonResult addMryProduct(MryProductAddParam mryProductAddParam) {
        MryProduct mryProduct = new MryProduct();
        mryProduct.setName(mryProductAddParam.getName());
        mryProduct.setType(mryProductAddParam.getType());
        mryProduct.setPicUrl(mryProductAddParam.getPicUrl());
        mryProduct.setCommunication(mryProductAddParam.getCommunication());
        mryProduct.setFunctionType(mryProductAddParam.getFunctionType());
        mryProduct.setGear(mryProductAddParam.getGear());
        mryProduct.setModel(mryProductAddParam.getModel());
        mryProduct.setNetworking(mryProductAddParam.getNetworking());
        mryProduct.setSpec(mryProduct.getSpec());

        if(StringUtils.isNotEmpty(mryProductAddParam.getModel()) && UserConstants.NOT_UNIQUE.equals(checkProductModeUnique(mryProduct))) {
            return CommonResult.error("新增产品'" + mryProductAddParam.getName() + "'失败，产品型号已存在");
        }
        if (insert(mryProduct) > 0) {
            if(mryProductAddParam.getUsages()!= null && mryProductAddParam.getUsages().size() > 0 ){
                List<MryProductUsageFunctions> usageList = mryProductAddParam.getUsages().stream().map(item -> {
                    MryProductUsageFunctions mryProductUsageFunction = new MryProductUsageFunctions();
                    mryProductUsageFunction.setProductId(mryProduct.getId());
                    mryProductUsageFunction.setContent(item.getContent());
                    mryProductUsageFunction.setTitle(item.getTitle());
                    mryProductUsageFunction.setPicUrl(item.getPicUrl());
                    mryProductUsageFunction.setType(1); //使用方法 2-产品功能介绍
                    return mryProductUsageFunction;
                }).collect(Collectors.toList());

                if(usageList != null && usageList.size() > 0) {
                    mryProductUsageFunctionsService.saveBatch(usageList);
                }
            }
            if(mryProductAddParam.getFunctions()!= null && mryProductAddParam.getFunctions().size() > 0) {
                List<MryProductUsageFunctions> functions = mryProductAddParam.getFunctions().stream().map(item -> {
                    MryProductUsageFunctions mryProductUsageFunction = new MryProductUsageFunctions();
                    mryProductUsageFunction.setProductId(mryProduct.getId());
                    mryProductUsageFunction.setContent(item.getContent());
                    mryProductUsageFunction.setTitle(item.getTitle());
                    mryProductUsageFunction.setPicUrl(item.getPicUrl());
                    mryProductUsageFunction.setType(2); //使用方法 2-产品功能介绍
                    return mryProductUsageFunction;
                }).collect(Collectors.toList());
                if(functions != null && functions.size() > 0) {
                    mryProductUsageFunctionsService.saveBatch(functions);
                }
            }
        }
        return CommonResult.ok("添加成功");
    }


    @Transactional
    public CommonResult updateMryProduct(MryProductEditParam mryProductEditParam) {
        MryProduct mryProduct =  mryProductMapper.selectById(mryProductEditParam.getId());
        if(mryProduct == null) {
            return CommonResult.error("产品记录不存在或已被删除");
        }
        if(StringUtils.isNotEmpty(mryProductEditParam.getModel()) && UserConstants.NOT_UNIQUE.equals(checkProductModeUnique(mryProduct))) {
            return CommonResult.error("新增产品'" + mryProductEditParam.getName() + "'失败，产品型号已存在");
        }

        mryProduct.setName(mryProductEditParam.getName());
        mryProduct.setType(mryProductEditParam.getType());
        mryProduct.setPicUrl(mryProductEditParam.getPicUrl());
        mryProduct.setCommunication(mryProductEditParam.getCommunication());
        mryProduct.setFunctionType(mryProductEditParam.getFunctionType());
        mryProduct.setGear(mryProductEditParam.getGear());
        mryProduct.setModel(mryProductEditParam.getModel());
        mryProduct.setNetworking(mryProductEditParam.getNetworking());
        mryProduct.setSpec(mryProductEditParam.getSpec());


        if (update(mryProduct) > 0) {
            if(mryProductEditParam.getUsages()!= null && mryProductEditParam.getUsages().size() > 0 ){
                List<MryProductUsageFunctions> usageList = mryProductEditParam.getUsages().stream().map(item -> {
                    MryProductUsageFunctions mryProductUsageFunction = new MryProductUsageFunctions();
                    mryProductUsageFunction.setId(item.getId());
                    mryProductUsageFunction.setProductId(mryProduct.getId());
                    mryProductUsageFunction.setContent(item.getContent());
                    mryProductUsageFunction.setTitle(item.getTitle());
                    mryProductUsageFunction.setPicUrl(item.getPicUrl());
                    mryProductUsageFunction.setType(1); //使用方法 2-产品功能介绍
                    return mryProductUsageFunction;
                }).collect(Collectors.toList());

                if(usageList != null && usageList.size() > 0) {
                    mryProductUsageFunctionsService.saveOrUpdateBatch(usageList);
                }
            }

            if(mryProductEditParam.getFunctions()!= null && mryProductEditParam.getFunctions().size() > 0) {
                List<MryProductUsageFunctions> functions = mryProductEditParam.getFunctions().stream().map(item -> {
                    MryProductUsageFunctions mryProductUsageFunction = new MryProductUsageFunctions();
                    mryProductUsageFunction.setId(item.getId());
                    mryProductUsageFunction.setProductId(mryProduct.getId());
                    mryProductUsageFunction.setContent(item.getContent());
                    mryProductUsageFunction.setTitle(item.getTitle());
                    mryProductUsageFunction.setPicUrl(item.getPicUrl());
                    mryProductUsageFunction.setType(2); //使用方法 2-产品功能介绍
                    return mryProductUsageFunction;
                }).collect(Collectors.toList());

                if(functions != null && functions.size() > 0) {
                    mryProductUsageFunctionsService.saveOrUpdateBatch(functions);
                }
            }

        }
        return CommonResult.ok("修改成功");
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
        mryProduct.setUpdateTime(LocalDateTime.now());
        return mryProductMapper.insert(mryProduct);
    }

    /**
     * 修改产品管理
     *
     * @param mryProduct 产品管理
     * @return 结果
     */
    public int update(MryProduct mryProduct) {
        mryProduct.setUpdateTime(LocalDateTime.now());
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



    public MryProduct getProductEntityByMode(MryProduct mryProduct) {
        QueryWrapper<MryProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(MryProduct::getModel, mryProduct.getModel());
        return mryProductMapper.selectOne(queryWrapper);
    }

    public String checkProductModeUnique(MryProduct product) {
        String productId = com.ruoyi.common.utils.StringUtils.isEmpty(product.getId()) ? "-1" : product.getId();
        MryProduct info = getProductEntityByMode(product);
        if (info != null && !productId.equalsIgnoreCase(info.getId())) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }
}
