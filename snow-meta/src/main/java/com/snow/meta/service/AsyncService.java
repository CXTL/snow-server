package com.snow.meta.service;

import com.snow.meta.entity.MetaDatasourceInfo;

public interface AsyncService {

    public void actualSync(MetaDatasourceInfo datasourceInfo);
}
