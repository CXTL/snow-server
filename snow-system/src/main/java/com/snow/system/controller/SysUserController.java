package com.snow.system.controller;

import api.CommonResult;
import com.snow.system.service.SysUserService;
import domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value = "findUserByUsername")
    public CommonResult<UserDto> findUserByUsername(@RequestParam(value="username") String username){
        return CommonResult.success(sysUserService.findUserByUsername(username));
    }






}
