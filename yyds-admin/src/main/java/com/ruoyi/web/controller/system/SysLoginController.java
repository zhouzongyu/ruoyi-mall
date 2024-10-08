package com.ruoyi.web.controller.system;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.CommonResult;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.common.core.domain.model.PhoneLoginBody;
import com.ruoyi.common.core.domain.vo.LoginResultVo;
import com.ruoyi.common.core.domain.vo.SysUserInfoVo;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.web.service.SysLoginService;
import com.ruoyi.framework.web.service.SysPermissionService;
import com.ruoyi.system.domain.vo.RouterVo;
import com.ruoyi.system.service.ISysMenuService;
import com.ruoyi.system.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * 登录验证
 * 
 * @author ruoyi
 */
@Api(tags = "登录接口")
@RestController
public class SysLoginController {
    @Autowired
    private SysLoginService loginService;
    @Autowired
    private ISysMenuService menuService;
    @Autowired
    private SysPermissionService permissionService;
    @Autowired
    private ISysRoleService sysRoleService;

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @ApiOperation("登录")
    @PostMapping("/login")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "登录成功", response = AjaxResult.class),
            @ApiResponse(code = 400, message = "未授权"),
            @ApiResponse(code = 401, message = "请求参数错误"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public CommonResult<LoginResultVo> login(@RequestBody LoginBody loginBody) {
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), "",
                "");
        LoginResultVo loginResultVo = new LoginResultVo();
        loginResultVo.setToken(token);
        return CommonResult.data(loginResultVo);
    }

//    /**
//     * 使用手机号登陆
//     *
//     * @param loginBody 登录信息
//     * @return 结果
//     */
//    @PostMapping("/login/phone")
//    public AjaxResult login(@RequestBody PhoneLoginBody loginBody) {
//        AjaxResult ajax = AjaxResult.success();
//        SysUser user = loginService.phoneLogin(loginBody.getPhone(), loginBody.getCode(), loginBody.getUuid());
//        ajax.put(Constants.TOKEN, loginService.createToken(user));
//        return ajax;
//    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @ApiOperation("获取用户信息")
    @GetMapping("getUserInfo")
    public CommonResult<SysUserInfoVo> getInfo() {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
       // Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        SysUserInfoVo sysUserInfoVo = new SysUserInfoVo();
        sysUserInfoVo.setUserId(user.getUserId());
        sysUserInfoVo.setUserName(user.getUserName());
        sysUserInfoVo.setNickName(user.getNickName());
        sysUserInfoVo.setPhone(user.getPhonenumber());
        sysUserInfoVo.setRoleId(user.getRoleId());

        SysRole sysrole = sysRoleService.selectRoleById(user.getRoleId());
        if(sysrole != null ) {
            sysUserInfoVo.setRoleName(sysrole.getRoleName());
        }
        sysUserInfoVo.setPermissions(permissions);
        return CommonResult.data(sysUserInfoVo);
    }

    /**
     * 获取路由信息
     * 
     * @return 路由信息
     */
    @ApiOperation("获取路由信息")
    @GetMapping("getRouters")
    public CommonResult<List<RouterVo>> getRouters(){
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return CommonResult.data(menuService.buildMenus(menus));
    }
}
