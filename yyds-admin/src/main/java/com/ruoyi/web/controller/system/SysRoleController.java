package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.domain.model.SysRoleAddBody;
import com.ruoyi.common.core.domain.model.SysRoleEditBody;
import com.ruoyi.common.core.domain.query.SysRolePageParam;
import com.ruoyi.common.core.domain.vo.SysRoleVo;
import com.ruoyi.common.core.page.PageVo;
import com.ruoyi.system.service.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.service.SysPermissionService;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;

/**
 * 角色信息
 * 
 * @author ruoyi
 */
@Api(tags = "权限管理-角色管理")
@RestController
@RequestMapping("/system/role")
public class SysRoleController extends BaseController
{
    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private SysPermissionService permissionService;
    
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysMenuService menuService;

    @ApiOperation("获取角色列表")
    @PreAuthorize("@ss.hasPermi('system:role:list')")
    @GetMapping("/list")
    public CommonResult<PageVo<SysRoleVo>> list(SysRolePageParam sysRolePageParam,
                                                @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        Pageable pageable =  PageRequest.of(pageNum, pageSize);
        List<SysRole> list = roleService.selectRoleList(sysRolePageParam, pageable);
        List<SysRoleVo> roles = list.stream().map(item -> {
            SysRoleVo sysRoleVo = new SysRoleVo();
            sysRoleVo.setRoleId(item.getRoleId());
            sysRoleVo.setRoleName(item.getRoleName());
            sysRoleVo.setMeuns(menuService.getMenuFunctionListByRoleId(item.getRoleId()));
            return sysRoleVo;
        }).collect(Collectors.toList());

        PageVo pageVo = new PageVo<>();
        pageVo.setCurrent(pageNum);
        pageVo.setSize(pageSize);
        if (list instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page<?> page = (com.github.pagehelper.Page<?>) list;
            pageVo.setTotal(page.getTotal());
            pageVo.setPages(page.getPages());
        }

        pageVo.setRecords(roles);
        return CommonResult.data(pageVo);

    }

//    @Log(title = "角色管理", businessType = BusinessType.EXPORT)
//    @PreAuthorize("@ss.hasPermi('system:role:export')")
//    @GetMapping("/export")
//    public AjaxResult export(SysRole role)
//    {
//        List<SysRole> list = roleService.selectRoleList(role);
//        ExcelUtil<SysRole> util = new ExcelUtil<SysRole>(SysRole.class);
//        return util.exportExcel(list, "角色数据");
//    }

    /**
     * 根据角色编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:role:query')")
    @GetMapping(value = "/{roleId}")
    public AjaxResult getInfo(@PathVariable Long roleId)
    {
        roleService.checkRoleDataScope(roleId);
        return AjaxResult.success(roleService.selectRoleById(roleId));
    }

    /**
     * 新增角色
     */
    @ApiOperation("新增角色")
    @PreAuthorize("@ss.hasPermi('system:role:add')")
    @Log(title = "角色管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysRoleAddBody sysRoleBody)
    {
        SysRole role  = new SysRole();
        role.setRoleName(sysRoleBody.getRoleName());
        role.setMenuIds(sysRoleBody.getMenuIds());
        role.setDelFlag("0");
        if (UserConstants.NOT_UNIQUE.equals(roleService.checkRoleNameUnique(role)))
        {
            return AjaxResult.error("新增角色'" + role.getRoleName() + "'失败，角色名称已存在");
        }
        else if (UserConstants.NOT_UNIQUE.equals(roleService.checkRoleKeyUnique(role)))
        {
            return AjaxResult.error("新增角色'" + role.getRoleName() + "'失败，角色权限已存在");
        }
        role.setCreateBy(getUserId());
        return toAjax(roleService.insertRole(role));

    }

    /**
     * 修改保存角色
     */
    @ApiOperation("修改保存角色")
    @PreAuthorize("@ss.hasPermi('system:role:edit')")
    @Log(title = "角色管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysRoleEditBody sysRoleBody)
    {
        if(sysRoleBody.getRoleId() == null) {
            return AjaxResult.error("修改角色失败，角色ID为空");
        }
        SysRole role = new SysRole();
        role.setRoleId(sysRoleBody.getRoleId());
        role.setRoleName(sysRoleBody.getRoleName());
        role.setMenuIds(sysRoleBody.getMenuIds());
        roleService.checkRoleAllowed(role);
        if (UserConstants.NOT_UNIQUE.equals(roleService.checkRoleNameUnique(role)))
        {
            return AjaxResult.error("修改角色'" + role.getRoleName() + "'失败，角色名称已存在");
        }
        else if (UserConstants.NOT_UNIQUE.equals(roleService.checkRoleKeyUnique(role)))
        {
            return AjaxResult.error("修改角色'" + role.getRoleName() + "'失败，角色权限已存在");
        }
        role.setUpdateBy(getUserId());
        
        if (roleService.updateRole(role) > 0)
        {
            // 更新缓存用户权限
            LoginUser loginUser = getLoginUser();
            if (StringUtils.isNotNull(loginUser.getUser()) && !loginUser.getUser().isAdmin())
            {
                loginUser.setPermissions(permissionService.getMenuPermission(loginUser.getUser()));
                loginUser.setUser(userService.selectUserByUserName(loginUser.getUser().getUserName()));
                tokenService.setLoginUser(loginUser);
            }
            return AjaxResult.success();
        }
        return AjaxResult.error("修改角色'" + role.getRoleName() + "'失败，请联系管理员");
    }

    /**
     * 修改保存数据权限
     */
    @PreAuthorize("@ss.hasPermi('system:role:edit')")
    @Log(title = "角色管理", businessType = BusinessType.UPDATE)
    @PutMapping("/dataScope")
    public AjaxResult dataScope(@RequestBody SysRole role)
    {
        roleService.checkRoleAllowed(role);
        return toAjax(roleService.authDataScope(role));
    }

    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('system:role:edit')")
    @Log(title = "角色管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysRole role)
    {
        roleService.checkRoleAllowed(role);
        role.setUpdateBy(getUserId());
        return toAjax(roleService.updateRoleStatus(role));
    }

    /**
     * 删除角色
     */
    @ApiOperation("删除角色")
    @PreAuthorize("@ss.hasPermi('system:role:remove')")
    @Log(title = "角色管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{roleIds}")
    public AjaxResult remove(@PathVariable Long[] roleIds)
    {
        return toAjax(roleService.deleteRoleByIds(roleIds));
    }

    /**
     * 获取角色选择框列表
     */
    @PreAuthorize("@ss.hasPermi('system:role:query')")
    @GetMapping("/optionselect")
    public AjaxResult optionselect()
    {
        return AjaxResult.success(roleService.selectRoleAll());
    }

//    /**
//     * 查询已分配用户角色列表
//     */
//    @PreAuthorize("@ss.hasPermi('system:role:list')")
//    @GetMapping("/authUser/allocatedList")
//    public TableDataInfo allocatedList(SysUser user)
//    {
//        startPage();
//        List<SysUser> list = userService.selectAllocatedList(user);
//        return getDataTable(list);
//    }
//
//    /**
//     * 查询未分配用户角色列表
//     */
//    @PreAuthorize("@ss.hasPermi('system:role:list')")
//    @GetMapping("/authUser/unallocatedList")
//    public TableDataInfo unallocatedList(SysUser user)
//    {
//        startPage();
//        List<SysUser> list = userService.selectUnallocatedList(user);
//        return getDataTable(list);
//    }
//
//    /**
//     * 取消授权用户
//     */
//    @PreAuthorize("@ss.hasPermi('system:role:edit')")
//    @Log(title = "角色管理", businessType = BusinessType.GRANT)
//    @PutMapping("/authUser/cancel")
//    public AjaxResult cancelAuthUser(@RequestBody SysUserRole userRole)
//    {
//        return toAjax(roleService.deleteAuthUser(userRole));
//    }
//
//    /**
//     * 批量取消授权用户
//     */
//    @PreAuthorize("@ss.hasPermi('system:role:edit')")
//    @Log(title = "角色管理", businessType = BusinessType.GRANT)
//    @PutMapping("/authUser/cancelAll")
//    public AjaxResult cancelAuthUserAll(Long roleId, Long[] userIds)
//    {
//        return toAjax(roleService.deleteAuthUsers(roleId, userIds));
//    }
//
//    /**
//     * 批量选择用户授权
//     */
//    @PreAuthorize("@ss.hasPermi('system:role:edit')")
//    @Log(title = "角色管理", businessType = BusinessType.GRANT)
//    @PutMapping("/authUser/selectAll")
//    public AjaxResult selectAuthUserAll(Long roleId, Long[] userIds)
//    {
//        return toAjax(roleService.insertAuthUsers(roleId, userIds));
//    }
}
