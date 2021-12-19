package com.snow.system.controller;

import api.CommonResult;
import com.snow.system.service.UserService;
import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "findUserByUsername")
    public CommonResult<UserDto> findUserByUsername(@RequestParam(value="username") String username){
        return CommonResult.success(userService.findUserByUsername(username));
    }






}
