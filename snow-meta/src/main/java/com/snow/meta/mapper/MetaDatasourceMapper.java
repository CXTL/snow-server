package com.snow.meta.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.meta.entity.MetaDatasourceInfo;
import com.snow.core.dto.meta.DatasourceDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MetaDatasourceMapper extends BaseMapper<MetaDatasourceInfo> {

    List<DatasourceDto> listDatasourceByPage();
}
