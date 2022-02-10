package com.snow.meta.controller;

import api.CommonResult;
import com.snow.meta.service.MetaDatasourceService;
import domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class MetaDatasourceController {

    @Autowired
    private MetaDatasourceService metaDatasourceService;

    @GetMapping(value = "findUserByUsername")
    public CommonResult<UserDto> findUserByUsername(@RequestParam(value="username") String username){
        return CommonResult.success(null);
    }


}
