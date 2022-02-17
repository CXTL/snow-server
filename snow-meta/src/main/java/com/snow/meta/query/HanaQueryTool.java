package com.snow.meta.query;

import com.snow.core.dto.meta.DatasourceDto;

import java.sql.SQLException;

/**
 * Hana数据库使用的查询工具
 *
 */
public class HanaQueryTool extends BaseQueryTool implements QueryToolInterface {

    public HanaQueryTool(DatasourceDto jobDatasource) throws SQLException {
        super(jobDatasource);
    }
}
