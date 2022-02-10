package com.snow.system.controller;

import api.CommonResult;
import com.snow.system.dto.UmsAdminLoginParam;
import com.snow.system.service.SysUserService;
import domain.UserDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value = "findUserByUsername")
    public CommonResult<UserDto> findUserByUsername(@RequestParam(value="username") String username){
        return CommonResult.success(sysUserService.findUserByUsername(username));
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@Validated @RequestBody UmsAdminLoginParam umsAdminLoginParam) {
        return sysUserService.login(umsAdminLoginParam.getUsername(),umsAdminLoginParam.getPassword());
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
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