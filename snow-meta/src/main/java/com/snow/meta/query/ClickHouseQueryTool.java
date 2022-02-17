package com.snow.meta.query;

import com.snow.core.dto.meta.DatasourceDto;

import java.sql.SQLException;

/**
 * ClickHouse
 */

public class ClickHouseQueryTool extends BaseQueryTool implements QueryToolInterface {
    /**
     * 构造方法
     *
     * @param jobJdbcDatasource
     */
  public ClickHouseQueryTool(DatasourceDto jobJdbcDatasource) throws SQLException {
        super(jobJdbcDatasource);
    }
}
