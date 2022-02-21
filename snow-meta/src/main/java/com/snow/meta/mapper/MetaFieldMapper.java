package com.snow.meta.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.meta.entity.MetaDatasourceInfo;
import com.snow.meta.entity.MetaFieldInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MetaFieldMapper extends BaseMapper<MetaFieldInfo> {

    void batchInsert(List<MetaFieldInfo> metaFieldInfos);
}
