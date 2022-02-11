package com.snow.system.service.impl;

import api.CommonResult;
import cn.hutool.core.util.StrUtil;
import com.alibaba.nacos.common.utils.CollectionUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.snow.system.entity.SysRole;
import com.snow.system.entity.SysUser;
import com.snow.system.mapper.SysRoleMapper;
import com.snow.system.mapper.SysUserMapper;
import com.snow.system.service.AuthService;
import com.snow.system.service.SysUserService;
import constant.AuthConstant;
import domain.UserDto;
import exception.Asserts;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private AuthService authService;

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

    @Override
    public CommonResult login(String username, String password) {
        if (StrUtil.isEmpty(username) || StrUtil.isEmpty(password)) {
            Asserts.fail("用户名或密码不能为空！");
        }
        Map<String, String> params = new HashMap<>();
        params.put("client_id", AuthConstant.ADMIN_CLIENT_ID);
        params.put("client_secret", "123456");
        params.put("grant_type", "password");
        params.put("username", username);
        params.put("password", password);
        CommonResult restResult = authService.getAccessToken(params);
//        if(ResultCode.SUCCESS.getCode()==restResult.getCode()&&restResult.getData()!=null){
////            updateLoginTimeByUsername(username);
//            insertLoginLog(username);
//        }
        return restResult;
    }


}
