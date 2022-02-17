package com.snow.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.snow.redis.service.RedisService;
import com.snow.system.entity.SysPermission;
import com.snow.system.entity.SysRole;
import com.snow.system.entity.SysRolePermission;
import com.snow.system.mapper.SysPermissionMapper;
import com.snow.system.mapper.SysRoleMapper;
import com.snow.system.mapper.SysRolePermissionMapper;
import com.snow.system.service.SysPermissionService;
import com.snow.core.constant.AuthConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public void initResourceRolesMap() {
        Map<String, List<String>> resourceRoleMap = new TreeMap<>();
        List<SysPermission> sysPermissions = sysPermissionMapper.selectList(new LambdaQueryWrapper<>());
        List<SysRolePermission> sysRolePermissions = sysRolePermissionMapper.selectList(new LambdaQueryWrapper<>());
        List<SysRole> sysRoles = sysRoleMapper.selectList(new LambdaQueryWrapper<>());
        for (SysPermission sysPermission : sysPermissions) {
            Set<Long> rolesIds = sysRolePermissions.stream()
                    .filter(item -> item.getPermissionId().equals(sysPermission.getId()))
                    .map(SysRolePermission::getRoleId).collect(Collectors.toSet());
            List<String> roleNames = sysRoles.stream()
                    .filter(item -> rolesIds.contains(item.getId()))
                    .map(SysRole::getName).collect(Collectors.toList());
            resourceRoleMap.put("/" + sysPermission.getUrlPerm(), roleNames);
        }
        redisService.del(AuthConstant.RESOURCE_ROLES_MAP_KEY);
        redisService.hSetAll(AuthConstant.RESOURCE_ROLES_MAP_KEY, resourceRoleMap);
    }
}
