package com.snow.system.service;

import dto.UserDto;

public interface UserService {
    UserDto findUserByUsername(String username);
}
