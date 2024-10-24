package com.yyds.yaman.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.db.DaoTemplate;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.PageVo;
import com.yyds.yaman.pojo.query.MryMessageAddParam;
import com.yyds.yaman.pojo.query.MryMessageEditParam;
import com.yyds.yaman.pojo.query.MryMessageQuery;
import com.yyds.yaman.pojo.vo.MryMessageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.enums.BusinessType;
import com.yyds.yaman.domain.MryMessage;
import com.yyds.yaman.service.MryMessageService;
/**
 * 消息Controller
 *
 * @author zzy
 * @date 2024-09-14
 */
@Api(tags ="运营中心-消息推送接口列表")
@RestController
@RequestMapping("/yaman/message")
public class MryMessageController extends BaseController {
    @Autowired
    private MryMessageService service;

    @ApiOperation("查询消息列表")
    @PreAuthorize("@ss.hasPermi('yaman:mryMessage:list')")
    @GetMapping("/list")
    public CommonResult<PageVo<MryMessageVO>> list(MryMessageQuery query,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<MryMessage> list = service.selectList(query, pageNum, pageSize);
        List<MryMessageVO> recordList = list.stream().map(item -> {
            MryMessageVO recordVO = new MryMessageVO();
            recordVO.setId(item.getId());
            recordVO.setMsgTitle(item.getMsgTitle());
            recordVO.setMsgContent(item.getMsgContent());
            recordVO.setMsgStatus(item.getMsgStatus());
            recordVO.setAreaCodes(item.getAreaCodes());
            recordVO.setAreaNames(item.getAreaNames());
            recordVO.setCreateTime(item.getCreateTime());
            recordVO.setPublishTime(item.getPublishTime());
            return recordVO;
        }).collect(Collectors.toList());

        PageVo<MryMessageVO> resultPage = new PageVo<MryMessageVO>();
        resultPage.setRecords(recordList);
        resultPage.setCurrent(pageNum);
        resultPage.setSize(pageSize);
        if (list instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page<?> page = (com.github.pagehelper.Page<?>) list;
            resultPage.setTotal(page.getTotal());
            resultPage.setPages(page.getPages());
        }
        return CommonResult.data(resultPage);
    }



    @ApiOperation("获取消息详细信息")
    @PreAuthorize("@ss.hasPermi('yaman:message:query')")
    @GetMapping(value = "/{id}")
    public CommonResult<MryMessage> getInfo(@PathVariable("id") Integer id) {
        return CommonResult.data(service.selectById(id));
    }

    @ApiOperation("新增消息")
    @PreAuthorize("@ss.hasPermi('yaman:message:add')")
    @Log(title = "新增消息", businessType = BusinessType.INSERT)
    @PostMapping
    public CommonResult add(@Validated @RequestBody MryMessageAddParam mryMessageAddParam) {
        MryMessage mryMessage = new MryMessage();
        mryMessage.setMsgTitle(mryMessageAddParam.getMsgTitle());
        mryMessage.setMsgContent(mryMessageAddParam.getMsgContent());
        mryMessage.setAreaCodes(mryMessageAddParam.getAreaCodes());
        mryMessage.setAreaNames(mryMessageAddParam.getAreaName());
        mryMessage.setMsgStatus(0); // 0-待发布 1-已发布
        int rows = service.insert(mryMessage);
        return rows > 0 ? CommonResult.ok("添加成功"): CommonResult.error("添加失败");

    }

    @ApiOperation("修改消息")
    @PreAuthorize("@ss.hasPermi('yaman:message:edit')")
    @Log(title = "修改消息", businessType = BusinessType.UPDATE)
    @PutMapping
    public CommonResult edit(@Validated @RequestBody MryMessageEditParam mryMessageEditParam) {
        MryMessage mryMessage = service.selectById(mryMessageEditParam.getId());
        if(mryMessage == null) {
            return CommonResult.error("消息记录不存在");
        }
        mryMessage.setMsgTitle(mryMessageEditParam.getMsgTitle());
        mryMessage.setMsgContent(mryMessageEditParam.getMsgContent());
        mryMessage.setAreaCodes(mryMessageEditParam.getAreaCodes());
        mryMessage.setAreaNames(mryMessageEditParam.getAreaName());
        int rows = service.update(mryMessage);
        return rows > 0 ? CommonResult.ok("修改成功"): CommonResult.error("修改失败");
    }

    @ApiOperation("删除消息")
    @PreAuthorize("@ss.hasPermi('yaman:message:remove')")
    @Log(title = "删除消息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{id}")
    public CommonResult remove(@PathVariable Integer id) {
        int rows = service.deleteById(id);
        return rows > 0 ? CommonResult.ok("删除成功"): CommonResult.error("删除失败");
    }

    /**
     * 状态修改
     */
    @ApiOperation("消息发布")
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "消息发布", businessType = BusinessType.UPDATE)
    @PutMapping("/publishMessage/{id}")
    public CommonResult changeStatus(@PathVariable("id") Integer id) {

        MryMessage mryMessage = service.selectById(id);
        if(mryMessage == null) {
            return CommonResult.error("消息记录不存在");
        }
        mryMessage.setMsgStatus(1);
        mryMessage.setPublishTime(LocalDateTime.now());
        int rows = service.update(mryMessage);
        return rows > 0 ? CommonResult.ok("发布成功"): CommonResult.error("发布失败");

    }

}
