package com.snow.meta.query;

import dto.meta.DatasourceDto;

import java.sql.SQLException;

/**
 * hive
 *
 */
public class HiveQueryTool extends BaseQueryTool implements QueryToolInterface {
    public HiveQueryTool(DatasourceDto jobDatasource) throws SQLException {
        super(jobDatasource);
    }
}
