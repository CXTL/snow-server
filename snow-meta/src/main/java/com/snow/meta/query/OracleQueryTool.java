package com.snow.meta.query;

import dto.meta.DatasourceDto;

import java.sql.SQLException;

/**
 * Oracle数据库使用的查询工具
 *
 *
 */
public class OracleQueryTool extends BaseQueryTool implements QueryToolInterface {

    public OracleQueryTool(DatasourceDto jobDatasource) throws SQLException {
        super(jobDatasource);
    }
}
