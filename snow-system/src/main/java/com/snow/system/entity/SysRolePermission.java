package com.snow.system.entity;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class SysRolePermission {
    private Long roleId;
    private Long permissionId;
}
