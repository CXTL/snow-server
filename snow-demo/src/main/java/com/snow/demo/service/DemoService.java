package com.snow.demo.service;

import dto.UserDto;
import dto.UserReq;

import java.util.List;

public interface DemoService {
    Integer add(UserReq userReq);

    Integer update(UserReq userReq);

    Integer delete(Long userId);

    UserDto findUserById(Long userId);

    List<UserDto> listUser();

    List<UserDto> pageListUser(Integer pageSize, Integer pageNum);
}
