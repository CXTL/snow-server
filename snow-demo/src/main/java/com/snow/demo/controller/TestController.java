package com.snow.demo.controller;

import api.CommonResult;
import com.snow.demo.feign.FeignSystemService;
import dto.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private FeignSystemService feignSystemService;

    @PostMapping(value = "add")
    public CommonResult<Integer> add(@RequestBody UserReq userReq) {
        return feignSystemService.add(userReq);
    }

    @GetMapping(value = "findUserById")
    public CommonResult<UserDto> findUserById(@RequestParam(value="userId") Long userId) {
        return feignSystemService.findUserById(userId);
    }

}
