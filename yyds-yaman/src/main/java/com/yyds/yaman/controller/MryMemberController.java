package com.yyds.yaman.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.page.PageVo;
import com.yyds.yaman.convert.MryDeviceConvert;
import com.yyds.yaman.pojo.dto.MryDeviceDTO;
import com.yyds.yaman.pojo.query.MryMemberQuery;
import com.yyds.yaman.pojo.query.MryMemberUpdateParam;
import com.yyds.yaman.pojo.query.MryProductQuery;
import com.yyds.yaman.pojo.vo.*;
import com.yyds.yaman.service.MryDeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.enums.BusinessType;
import com.yyds.yaman.domain.MryMember;
import com.yyds.yaman.service.MryMemberService;

/**
 * 会员Controller
 *
 * @author zzy
 * @date 2024-09-11
 */
@Api(tags = "会员管理接口" )
@RestController
@RequestMapping("/yaman/member" )
public class MryMemberController extends BaseController {
    @Autowired
    private MryMemberService service;

    @Autowired
    private MryDeviceService deviceService;

    @Autowired
    private MryDeviceConvert mryDeviceConvert;

    @ApiOperation("查询会员列表" )
    @PreAuthorize("@ss.hasPermi('yaman:member:list')" )
    @GetMapping("/list" )
    public CommonResult<PageVo<MryMemberVO>> list(MryMemberQuery query,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                  @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<MryMember> list = service.selectList(query, pageNum, pageSize);
        List<MryMemberVO> userList = new ArrayList<>();
        if(list!= null && list.size() > 0) {
            List<String> userIds = list.stream().map(item->item.getId()).collect(Collectors.toList());
            List<MryDeviceDTO> deviceListByUserIds = deviceService.getDeviceListByUserIds(userIds);
            Map<String, List<MryDeviceDTO>> mapDeviceListByUserId = deviceListByUserIds.stream().collect(Collectors.groupingBy(MryDeviceDTO::getUserId));

                userList = list.parallelStream().map(item -> {
                MryMemberVO mryMemberVO = new MryMemberVO();
                mryMemberVO.setCreateTime(item.getCreateTime());
                mryMemberVO.setId(item.getId());
                mryMemberVO.setPhone(item.getPhone());
                mryMemberVO.setUserName(item.getUserName());
                mryMemberVO.setVipNumber(item.getVipNumber());
                mryMemberVO.setRemark(item.getRemark());
                mryMemberVO.setDeviceStatus(0);
                if(mapDeviceListByUserId.containsKey(item.getId())) {
                    mryMemberVO.setDeviceStatus(1);
                    mryMemberVO.setDevices(mryDeviceConvert.dos2vos(mapDeviceListByUserId.get(item.getId())));
                }
//            mryMemberVO.setDevices(deviceService.getDeviceListByUserId(mryMemberVO.getId()));
//            if(mryMemberVO.getDevices()!= null && !mryMemberVO.getDevices().isEmpty()) {
//                mryMemberVO.setDeviceStatus(1);
//            }else {
//                mryMemberVO.setDeviceStatus(0);
//            }
                return mryMemberVO;
            }).collect(Collectors.toList());
        }

        PageVo<MryMemberVO> resultPage = new PageVo<>();
        resultPage.setRecords(userList);
        resultPage.setCurrent(pageNum);
        resultPage.setSize(pageSize);
        if (list instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page<?> page = (com.github.pagehelper.Page<?>) list;
            resultPage.setTotal(page.getTotal());
            resultPage.setPages(page.getPages());
        }
        return CommonResult.data(resultPage);
    }

//    @ApiOperation("导出会员列表")
//    @PreAuthorize("@ss.hasPermi('yaman:mryMember:export')")
//    @Log(title = "会员", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public ResponseEntity<String> export(MryMemberQuery query) {
//        List<MryMember> list = service.selectList(query, null);
//        ExcelUtil<MryMemberVo}> util = new ExcelUtil<>(MryMemberVo}.class);
//        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "会员数据"));
//    }

    @ApiOperation("获取会员详细信息" )
    @PreAuthorize("@ss.hasPermi('yaman:member:query')" )
    @GetMapping(value = "/{id}" )
    public CommonResult<MryMemberDetailVo> getInfo(@PathVariable("id" ) String id) {
        return CommonResult.data(service.getUserInfo(id));
    }


    @ApiOperation("修改会员信息(如备注或会员号)" )
    @PreAuthorize("@ss.hasPermi('yaman:member:edit')" )
    @Log(title = "修改会员", businessType = BusinessType.UPDATE)
    @PutMapping
    public CommonResult edit(@RequestBody MryMemberUpdateParam mryMemberUpdateParam) {
        MryMember mryMember = service.selectById(mryMemberUpdateParam.getId());
        if(mryMember == null) {
            return CommonResult.error("会员不存在");
        }
        mryMember.setRemark(mryMemberUpdateParam.getRemark());
        mryMember.setVipNumber(mryMemberUpdateParam.getVipNumber());

        if(StringUtils.isNotEmpty(mryMemberUpdateParam.getVipNumber())) {
            MryMember otherMember = service.getByVipNumber(mryMember.getVipNumber());
            if(otherMember != null && !otherMember.getId().equals(mryMember.getId())) {
                return CommonResult.error("会员号重复");
            }
        }

        int rows = service.update(mryMember);
        return rows > 0 ? CommonResult.ok("修改成功") : CommonResult.error("修改失败");
    }

    @ApiOperation("删除会员" )
    @PreAuthorize("@ss.hasPermi('yaman:member:remove')" )
    @Log(title = "删除会员", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}" )
    public CommonResult remove(@PathVariable String id) {
        MryMember mryMember = service.selectById(id);
        if(mryMember == null) {
            return CommonResult.error("会员不存在");
        }

        int rows = service.deleteUser(mryMember);
        return rows > 0 ? CommonResult.ok("删除成功") : CommonResult.error("删除失败");
    }
}
