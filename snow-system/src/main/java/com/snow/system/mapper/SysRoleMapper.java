package com.snow.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.system.entity.SysRole;
import com.snow.system.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> listRoleByUserId(@Param("userId") Long userId);
}
