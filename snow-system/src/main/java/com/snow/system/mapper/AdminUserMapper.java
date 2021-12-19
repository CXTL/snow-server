package com.snow.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.system.entity.UmsAdmin;
import dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminUserMapper extends BaseMapper<UmsAdmin> {

    List<UserDto> getList();
}
