package com.snow.meta.query;

import dto.meta.DatasourceDto;

import java.sql.SQLException;

/**
 * sql server
 *
 */
public class SqlServerQueryTool extends BaseQueryTool implements QueryToolInterface {
    public SqlServerQueryTool(DatasourceDto jobDatasource) throws SQLException {
        super(jobDatasource);
    }
}
