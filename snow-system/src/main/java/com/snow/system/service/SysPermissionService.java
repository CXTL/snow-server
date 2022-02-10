package com.snow.system.service;

public interface SysPermissionService {


    /**
     * 刷新Redis缓存中角色菜单的权限规则，角色和菜单信息变更调用
     */
    void initResourceRolesMap();

}
