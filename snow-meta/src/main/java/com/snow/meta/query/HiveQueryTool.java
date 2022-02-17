package com.snow.meta.query;

import com.snow.core.dto.meta.DatasourceDto;

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
