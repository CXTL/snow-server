package com.snow.meta.query;

import com.snow.core.dto.meta.DatasourceDto;

import java.sql.SQLException;

/**
 * mysql数据库使用的查询工具
 *
 */
public class MySQLQueryTool extends BaseQueryTool implements QueryToolInterface {

    public MySQLQueryTool(DatasourceDto jobDatasource) throws SQLException {
        super(jobDatasource);
    }

}
