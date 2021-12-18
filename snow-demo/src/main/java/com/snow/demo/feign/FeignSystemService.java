package com.snow.demo.feign;

import api.CommonResult;
import constant.ServiceInfoConstant;
import dto.UserDto;
import dto.UserReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(ServiceInfoConstant.SERVICE_NAME_SYSTEM)
public interface FeignSystemService {

    @PostMapping(value = "user/add")
    CommonResult<Integer> add(@RequestBody UserReq userReq);


    @GetMapping(value = "user/findUserById")
    CommonResult<UserDto> findUserById(@RequestParam(value="userId") Long userId);

}
