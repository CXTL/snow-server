package com.snow.system.service;

import dto.UserDto;
import dto.UserReq;

import java.util.List;

public interface UserService {
    Integer add(UserReq userReq);

    Integer update(UserReq userReq);

    Integer delete(Long userId);

    UserDto findUserById(Long userId);

    List<UserDto> listUser();

    List<UserDto> pageListUser(Integer pageSize, Integer pageNum);
}
