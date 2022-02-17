package com.snow.system.controller;

import com.snow.mybatis.CommonResult;
import com.snow.system.dto.UmsAdminLoginParam;
import com.snow.system.service.SysUserService;
import com.snow.core.domain.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户信息API")
@RestController
@RequestMapping(value = "user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "根据用户名称获取用户信息")
    @GetMapping(value = "findUserByUsername")
    public CommonResult<UserDto> findUserByUsername(@RequestParam(value="username") String username){
        return CommonResult.success(sysUserService.findUserByUsername(username));
    }

    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
    public CommonResult login(@Validated @RequestBody UmsAdminLoginParam umsAdminLoginParam) {
        return sysUserService.login(umsAdminLoginParam.getUsername(),umsAdminLoginParam.getPassword());
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping(value = "/info")
    public CommonResult getAdminInfo() {
//        UmsAdmin umsAdmin = sysUserService.getCurrentAdmin();
//        Map<String, Object> data = new HashMap<>();
//        data.put("username", umsAdmin.getUsername());
//        data.put("menus", roleService.getMenuList(umsAdmin.getId()));
//        data.put("icon", umsAdmin.getIcon());
//        List<UmsRole> roleList = adminService.getRoleList(umsAdmin.getId());
//        if(CollUtil.isNotEmpty(roleList)){
//            List<String> roles = roleList.stream().map(UmsRole::getName).collect(Collectors.toList());
//            data.put("roles",roles);
//        }
//        return CommonResult.success(data);
        return null;
    }

}
