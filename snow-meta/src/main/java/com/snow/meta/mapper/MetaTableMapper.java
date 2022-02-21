package com.snow.meta.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.meta.entity.MetaDatasourceInfo;
import com.snow.meta.entity.MetaTableInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MetaTableMapper extends BaseMapper<MetaTableInfo> {

    void deleteByDsId(@Param("datasourceId") Long datasourceId);
}
