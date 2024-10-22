package com.ruoyi.web.controller.system;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.domain.model.SysUserAddParam;
import com.ruoyi.common.core.domain.model.SysUserEditParam;
import com.ruoyi.common.core.domain.query.ChangeUserStatusParam;
import com.ruoyi.common.core.domain.query.SysUserPageParam;

import com.ruoyi.common.core.domain.vo.SysUserVo;
import com.ruoyi.common.core.page.PageVo;
import com.ruoyi.system.service.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.ISysPostService;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;

/**
 * 管理员列表
 * 
 */
@Api(tags = "权限管理-管理员管理")
@RestController
@RequestMapping("/system/user")
public class SysUserController extends BaseController
{
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;


    @Autowired
    private ISysMenuService menuService;


    @ApiOperation("获取管理员列表")
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/list")
    public CommonResult<PageVo<SysUserVo>>  list(SysUserPageParam query,
                                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        List<SysUser> list = userService.selectUserPage(query, pageNum, pageSize);
        List<SysUserVo> users  = list.stream().map(item -> {
            SysUserVo sysUserVo = new SysUserVo();
            sysUserVo.setUserId(item.getUserId());
            sysUserVo.setUserName(item.getUserName());
            sysUserVo.setNickName(item.getNickName());
            sysUserVo.setPhone(item.getPhonenumber());
            sysUserVo.setRoleId(item.getRoleId());
            sysUserVo.setStatus(item.getStatus());
            sysUserVo.setCreateTime(item.getCreateTime());
            sysUserVo.setRoleName(roleService.selectRoleById(item.getRoleId()).getRoleName());
            sysUserVo.setMeuns(menuService.getMenuFunctionListByRoleId(item.getRoleId()));
            return sysUserVo;
        }).collect(Collectors.toList());

        PageVo<SysUserVo> resultPage = new PageVo<>();
        resultPage.setRecords(users);
        resultPage.setCurrent(pageNum);
        resultPage.setSize(pageSize);
        if (list instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page<?> page = (com.github.pagehelper.Page<?>) list;
            resultPage.setTotal(page.getTotal());
            resultPage.setPages(page.getPages());
        }
        return CommonResult.data(resultPage);
    }

//    /**
//     * 获取用户列表
//     */
//    @PreAuthorize("@ss.hasPermi('system:user:list')")
//    @GetMapping("/list")
//    public TableDataInfo list(SysUser user)
//    {
//        startPage();
//        List<SysUser> list = userService.selectUserList(user);
//        return getDataTable(list);
//    }

//    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
//    @PreAuthorize("@ss.hasPermi('system:user:export')")
//    @GetMapping("/export")
//    public AjaxResult export(SysUser user)
//    {
//        List<SysUser> list = userService.selectUserList(user);
//        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
//        return util.exportExcel(list, "用户数据");
//    }
//
//    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
//    @PreAuthorize("@ss.hasPermi('system:user:import')")
//    @PostMapping("/importData")
//    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
//    {
//        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
//        List<SysUser> userList = util.importExcel(file.getInputStream());
//        String message = userService.importUser(userList, updateSupport, getUserId());
//        return AjaxResult.success(message);
//    }
//
//    @GetMapping("/importTemplate")
//    public AjaxResult importTemplate()
//    {
//        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
//        return util.importTemplateExcel("用户数据");
//    }

    /**
     * 根据用户编号获取详细信息
     */
    @ApiOperation("用户详细信息")
    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping(value = {  "/{userId}" })
    public CommonResult<SysUserVo> getInfo(@PathVariable(value = "userId", required = true) Long userId)
    {
        userService.checkUserDataScope(userId);
//        AjaxResult ajax = AjaxResult.success();
//        List<SysRole> roles = roleService.selectRoleAll();
//        ajax.put("roles", SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
//        ajax.put("posts", postService.selectPostAll());
//        if (StringUtils.isNotNull(userId))
//        {
//            ajax.put(AjaxResult.DATA_TAG, userService.selectUserById(userId));
//            ajax.put("postIds", postService.selectPostListByUserId(userId));
//            ajax.put("roleIds", roleService.selectRoleListByUserId(userId));
//        }
        SysUser sysUser = userService.selectUserById(userId);
        SysUserVo sysUserVo = new SysUserVo();
        sysUserVo.setUserId(sysUser.getUserId());
        sysUserVo.setUserName(sysUser.getUserName());
        sysUserVo.setPhone(sysUser.getPhonenumber());
        sysUserVo.setRoleId(sysUser.getRoleId());
        sysUserVo.setRoleName(roleService.selectRoleById(sysUser.getRoleId()).getRoleName());
        return CommonResult.data(sysUserVo);
    }

    /**
     * 新增用户
     */
    @ApiOperation("新增用户")
    @PreAuthorize("@ss.hasPermi('system:user:add')")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysUserAddParam sysUserAddParam)
    {

        SysUser user = new SysUser();
        user.setPhonenumber(sysUserAddParam.getPhone());
        user.setUserName(sysUserAddParam.getUserName());

        if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(sysUserAddParam.getUserName())))
        {
            return AjaxResult.error("新增用户'" + sysUserAddParam.getUserName() + "'失败，登录账号已存在");
        }
        else if (StringUtils.isNotEmpty(sysUserAddParam.getPhone())
                && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user)))
        {
            return AjaxResult.error("新增用户'" + sysUserAddParam.getUserName() + "'失败，手机号码已存在");
        }
        user.setPassword(sysUserAddParam.getPassword());
        user.setNickName(sysUserAddParam.getNickName());
        user.setDelFlag("0");
        user.setRoleId(sysUserAddParam.getRoleId());
        user.setCreateBy(getUserId());
        return toAjax(userService.insertUser(user));
    }

    /**
     * 修改用户
     */
    @ApiOperation("修改用户")
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysUserEditParam sysUserEditParam)
    {
        SysUser user = userService.selectUserById(sysUserEditParam.getUserId());
        if(user == null) {
            return AjaxResult.error("用户不存");
        }
        userService.checkUserAllowed(user);
        if (StringUtils.isNotEmpty(user.getPhonenumber())
                && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user)))
        {
            return AjaxResult.error("修改用户'" + user.getUserName() + "'失败，手机号码已存在");
        }
        user.setNickName(sysUserEditParam.getNickName());
        user.setRoleId(sysUserEditParam.getRoleId());
        user.setUpdateBy(getUserId());
        return toAjax(userService.updateUser(user));
    }

    /**
     * 删除用户
     */
    @ApiOperation("删除用户")
    @PreAuthorize("@ss.hasPermi('system:user:remove')")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{userId}")
    public AjaxResult remove(@PathVariable Long userId)  {
        if ( userId.longValue() == getUserId().longValue()) {
            return error("当前用户不能删除");
        }
        return toAjax(userService.deleteUserById(userId));
    }

    /**
     * 重置密码
     */
    @PreAuthorize("@ss.hasPermi('system:user:resetPwd')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping("/resetPwd")
    public AjaxResult resetPwd(@RequestBody SysUser user)
    {
        userService.checkUserAllowed(user);
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        user.setUpdateBy(getUserId());
        return toAjax(userService.resetPwd(user));
    }

    /**
     * 状态修改
     */
    @ApiOperation("用户状态修改")
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus/{userId}")
    public AjaxResult changeStatus(@PathVariable("userId") Long userId,
                                   @RequestBody ChangeUserStatusParam changeUserStatusParam)
    {
        if (!"1".equalsIgnoreCase(changeUserStatusParam.getStatus()) && !"0".equalsIgnoreCase(changeUserStatusParam.getStatus())) {
            return AjaxResult.error("状态值错误 1-启动 0-停用");
        }
        SysUser user = userService.selectUserById(userId);
        userService.checkUserAllowed(user);
        user.setStatus(changeUserStatusParam.getStatus());
        user.setUpdateBy(getUserId());
        return toAjax(userService.updateUserStatus(user));
    }

    /**
     * 根据用户编号获取授权角色
     */
    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping("/authRole/{userId}")
    public AjaxResult authRole(@PathVariable("userId") Long userId)
    {
        AjaxResult ajax = AjaxResult.success();
        SysUser user = userService.selectUserById(userId);
        List<SysRole> roles = roleService.selectRolesByUserId(userId);
        ajax.put("user", user);
        ajax.put("roles", SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        return ajax;
    }

    /**
     * 用户授权角色
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.GRANT)
    @PutMapping("/authRole")
    public AjaxResult insertAuthRole(Long userId, Long[] roleIds)
    {
        userService.insertUserAuth(userId, roleIds);
        return success();
    }
}
