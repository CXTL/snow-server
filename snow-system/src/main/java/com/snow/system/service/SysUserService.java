package com.snow.system.service;

import com.snow.mybatis.CommonResult;
import com.snow.core.domain.UserDto;

public interface SysUserService {

    UserDto findUserByUsername(String username);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 调用认证中心返回结果
     */
    CommonResult login(String username, String password);
}
