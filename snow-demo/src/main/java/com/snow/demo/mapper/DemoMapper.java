package com.snow.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.demo.entity.UmsAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemoMapper extends BaseMapper<UmsAdmin> {

    List<UserDto> getList();
}
