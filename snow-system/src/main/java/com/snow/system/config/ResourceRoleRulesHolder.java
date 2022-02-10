package com.snow.system.config;

import com.snow.system.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 资源与角色访问对应关系操作组件
 * Created by macro on 2020/7/17.
 */
@Component
public class ResourceRoleRulesHolder {

    @Autowired
    private SysPermissionService sysPermissionService;

    @PostConstruct
    public void initResourceRolesMap(){
        sysPermissionService.initResourceRolesMap();
    }
}
