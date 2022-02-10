package com.snow.meta.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.meta.entity.MetaDatasourceInfo;
import com.snow.meta.entity.MetaFieldInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MetaFieldMapper extends BaseMapper<MetaFieldInfo> {

}
