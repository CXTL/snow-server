package com.snow.auth.service;

import com.snow.mybatis.CommonResult;
import com.snow.core.constant.ServiceInfoConstant;
import com.snow.core.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 */
@FeignClient(ServiceInfoConstant.SERVICE_NAME_SYSTEM)
public interface SysUserService {

    @GetMapping("/user/findUserByUsername")
    public CommonResult<UserDto> findUserByUsername(@RequestParam(value="username") String username);
}
