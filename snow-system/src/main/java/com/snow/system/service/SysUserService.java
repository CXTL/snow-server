package com.snow.system.service;

import domain.UserDto;

public interface SysUserService {

    UserDto findUserByUsername(String username);

}
