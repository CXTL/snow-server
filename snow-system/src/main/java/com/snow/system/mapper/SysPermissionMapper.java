package com.snow.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.system.entity.SysPermission;
import com.snow.system.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

}
