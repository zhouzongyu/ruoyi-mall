package com.yyds.yaman.controller;

import java.util.List;

import com.yyds.yaman.pojo.query.MryApplicationQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.enums.BusinessType;
import com.yyds.yaman.domain.MryApplication;
import com.yyds.yaman.service.MryApplicationService;
/**
 * 应用管理Controller
 *
 * @author zzy
 * @date 2024-09-11
 */
@Api(tags ="平台基本资料配置管理")
@RestController
@RequestMapping("/yaman/platform")
public class MryApplicationController extends BaseController {
    @Autowired
    private MryApplicationService service;


    @ApiOperation("获取平台资料配置信息")
    @PreAuthorize("@ss.hasPermi('yaman:firmware:list')")
    @GetMapping("/configInfo")
    public ResponseEntity<MryApplication> configInfo() {
        return ResponseEntity.ok(service.queryApplicationSetting());
    }


    @ApiOperation("修改系统资料配置信息")
    @PreAuthorize("@ss.hasPermi('yaman:firmware:list')")
    @Log(title = "修改系统资料配置信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody MryApplication mryApplication) {
        return ResponseEntity.ok(service.updateApplicationSetting(mryApplication));
    }

}