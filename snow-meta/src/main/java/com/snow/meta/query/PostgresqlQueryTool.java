package com.snow.meta.query;

import dto.meta.DatasourceDto;

import java.sql.SQLException;

/**
 * TODO
 *
 *
 */
public class PostgresqlQueryTool extends BaseQueryTool implements QueryToolInterface {
    public PostgresqlQueryTool(DatasourceDto jobDatasource) throws SQLException {
        super(jobDatasource);
    }

}
