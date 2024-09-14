package com.yyds.yaman.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.page.PageVo;
import com.yyds.yaman.pojo.query.MryMessageQuery;
import com.yyds.yaman.pojo.vo.MryMessageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(tags ="消息推送接口列表")
@RestController
@RequestMapping("/yaman/message")
public class MryMessageController extends BaseController {
    @Autowired
    private MryMessageService service;

    @ApiOperation("查询消息列表")
    @PreAuthorize("@ss.hasPermi('yaman:mryMessage:list')")
    @PostMapping("/list")
    public CommonResult<PageVo<MryMessageVO>> list(MryMessageQuery query,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<MryMessage> list = service.selectList(query, pageNum, pageSize);
        List<MryMessageVO> recordList = list.stream().map(item -> {
            MryMessageVO recordVO = new MryMessageVO();
            recordVO.setId(item.getId());
            recordVO.setCreateTime(item.getCreateTime());
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
    public ResponseEntity<MryMessage> getInfo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增消息")
    @PreAuthorize("@ss.hasPermi('yaman:message:add')")
    @Log(title = "消息", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody MryMessage mryMessage) {
        return ResponseEntity.ok(service.insert(mryMessage));
    }

    @ApiOperation("修改消息")
    @PreAuthorize("@ss.hasPermi('yaman:message:edit')")
    @Log(title = "消息", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody MryMessage mryMessage) {
        return ResponseEntity.ok(service.update(mryMessage));
    }

    @ApiOperation("删除消息")
    @PreAuthorize("@ss.hasPermi('yaman:message:remove')")
    @Log(title = "消息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Integer[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
