package com.snow.meta.service;

import com.snow.core.dto.meta.DatasourceDto;
import com.snow.core.dto.meta.DatasourceParam;

import java.util.List;

public interface MetaDatasourceService {

    DatasourceDto findDatasourceById(Long datasourceId);

    Integer add(DatasourceParam datasourceParam);

    Integer update(DatasourceParam datasourceParam);

    Integer delete(Long DatasourceId);

    List<DatasourceDto> listDatasource();

    List<DatasourceDto> pageListDatasource(Integer pageSize, Integer pageNum);

    Boolean connect(Long datasourceId);

    void sync(Long datasourceId);
}
