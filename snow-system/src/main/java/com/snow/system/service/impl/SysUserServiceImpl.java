package com.snow.system.service.impl;

import com.alibaba.nacos.common.utils.CollectionUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.snow.system.entity.SysRole;
import com.snow.system.entity.SysUser;
import com.snow.system.mapper.SysRoleMapper;
import com.snow.system.mapper.SysUserMapper;
import com.snow.system.service.SysUserService;
import domain.UserDto;
import exception.Asserts;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public UserDto findUserByUsername(String username) {
        SysUser sysUser = sysUserMapper.selectOne(
                new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
        if (Objects.isNull(sysUser)) {
            Asserts.fail("用户不存在");
        }
        List<SysRole> sysRoles = sysRoleMapper.listRoleByUserId(sysUser.getId());
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(sysUser, dto);
        if (CollectionUtils.isNotEmpty(sysRoles)) {
            List<String> roles =
                    sysRoles.stream().map(a -> a.getName()).collect(Collectors.toList());
            dto.setRoles(roles);
        }
        return dto;
    }


}
