package com.snow.system.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SysRoleMenu {

    private Long roleId;

    private Long menuId;

}