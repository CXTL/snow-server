package com.snow.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.snow.system.entity.SysUser;
import com.snow.system.mapper.UserMapper;
import com.snow.system.service.UserService;
import dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDto findUserByUsername(String username) {
        SysUser sysUser = userMapper.selectOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(sysUser, dto);
        return dto;
    }


}
