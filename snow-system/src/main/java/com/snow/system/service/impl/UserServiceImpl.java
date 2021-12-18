package com.snow.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.snow.system.entity.UmsAdmin;
import com.snow.system.mapper.UserMapper;
import com.snow.system.service.UserService;
import dto.UserDto;
import dto.UserReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer add(UserReq userReq) {
        UmsAdmin umsAdmin = UmsAdmin.builder().build();
        BeanUtils.copyProperties(userReq ,umsAdmin);
        umsAdmin.setCreateTime(new Date());
        return userMapper.insert(umsAdmin);
    }

    @Override
    public Integer update(UserReq userReq) {
        UmsAdmin umsAdmin = UmsAdmin.builder().build();
        BeanUtils.copyProperties(userReq ,umsAdmin);
        return userMapper.updateById(umsAdmin);
    }

    @Override
    public Integer delete(Long userId) {
        return userMapper.deleteById(userId);
    }

    @Override
    public UserDto findUserById(Long userId) {
        UmsAdmin umsAdmin = userMapper.selectById(userId);
        UserDto userDto = UserDto.builder().build();
        BeanUtils.copyProperties(umsAdmin, userDto);
        return userDto;
    }

    @Override
    public List<UserDto> listUser() {
        List<UmsAdmin> umsAdmins = userMapper.selectList(new LambdaQueryWrapper<>());
        return umsAdmins.stream().map(a->{
            UserDto userDto = UserDto.builder().build();
            BeanUtils.copyProperties(a, userDto);
            return userDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> pageListUser(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return  userMapper.getList();
    }
}
