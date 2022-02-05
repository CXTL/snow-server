package com.snow.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.system.entity.SysUser;
import com.snow.system.entity.UmsAdmin;
import dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<SysUser> {

}