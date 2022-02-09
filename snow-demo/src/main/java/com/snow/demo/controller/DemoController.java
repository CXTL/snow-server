package com.snow.demo.controller;

import api.CommonPage;
import api.CommonResult;
import com.snow.demo.service.DemoService;
import dto.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping(value = "add")
    public CommonResult<Integer> add(@RequestBody UserReq userReq) {
        return CommonResult.success(demoService.add(userReq));
    }

    @PostMapping(value = "update")
    public CommonResult<Integer> update(@RequestBody UserReq userReq) {
        return CommonResult.success(demoService.update(userReq));
    }

    @PostMapping(value = "delete")
    public CommonResult<Integer> delete(@RequestParam Long userId) {
        return CommonResult.success(demoService.delete(userId));
    }

    @GetMapping(value = "findUserById")
    public CommonResult<UserDto> findUserById(@RequestParam Long userId) {
        return CommonResult.success(demoService.findUserById(userId));
    }

    @GetMapping(value = "listUser")
    public CommonResult<List<UserDto>> listUser() {
        return CommonResult.success(demoService.listUser());
    }

    @PostMapping(value = "pageListUser")
    public CommonResult<CommonPage<UserDto>> pageListUser(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UserDto> userList = demoService.pageListUser(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(userList));
    }

}
