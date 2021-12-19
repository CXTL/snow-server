package com.snow.system.controller;

import api.CommonPage;
import api.CommonResult;
import com.snow.system.service.AdminUserService;
import dto.UserDto;
import dto.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "admin")
public class AdminUserController {

    @Autowired
    private AdminUserService userService;

    @PostMapping(value = "add")
    public CommonResult<Integer> add(@RequestBody UserReq userReq) {
        return CommonResult.success(userService.add(userReq));
    }

    @PostMapping(value = "update")
    public CommonResult<Integer> update(@RequestBody UserReq userReq) {
        return CommonResult.success(userService.update(userReq));
    }

    @PostMapping(value = "delete")
    public CommonResult<Integer> delete(@RequestParam Long userId) {
        return CommonResult.success(userService.delete(userId));
    }

    @GetMapping(value = "findUserById")
    public CommonResult<UserDto> findUserById(@RequestParam(value="userId") Long userId) {
        return CommonResult.success(userService.findUserById(userId));
    }

    @GetMapping(value = "listUser")
    public CommonResult<List<UserDto>> listUser() {
        return CommonResult.success(userService.listUser());
    }

    @PostMapping(value = "pageListUser")
    public CommonResult<CommonPage<UserDto>> pageListUser(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UserDto> userList = userService.pageListUser(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(userList));
    }





}
