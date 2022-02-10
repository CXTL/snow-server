package com.snow.system.service;

import api.CommonResult;
import constant.ServiceInfoConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 认证服务远程调用
 * Created by macro on 2020/7/19.
 */
@FeignClient(ServiceInfoConstant.SERVICE_NAME_AUTH)
public interface AuthService {

    @PostMapping(value = "/oauth/token")
    CommonResult getAccessToken(@RequestParam Map<String, String> parameters);

}
