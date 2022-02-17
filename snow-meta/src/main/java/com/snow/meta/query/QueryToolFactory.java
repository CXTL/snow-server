package com.snow.meta.query;

import com.snow.core.constant.JdbcConstant;
import com.snow.core.dto.meta.DatasourceDto;
import com.snow.core.exception.Asserts;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

/**
 * 工具类，获取单例实体
 *
 *
 */
@Slf4j
public class QueryToolFactory {

    public static BaseQueryTool getByDbType(DatasourceDto jobDatasource) {
        //获取dbType
        String datasource = jobDatasource.getType();
        if (JdbcConstant.MYSQL.equals(datasource)) {
            return getMySQLQueryToolInstance(jobDatasource);
        } else if (JdbcConstant.ORACLE.equals(datasource)) {
            return getOracleQueryToolInstance(jobDatasource);
        } else if (JdbcConstant.POSTGRESQL.equals(datasource)) {
            return getPostgresqlQueryToolInstance(jobDatasource);
        } else if (JdbcConstant.SQL_SERVER.equals(datasource)) {
            return getSqlserverQueryToolInstance(jobDatasource);
        } else if (JdbcConstant.HIVE.equals(datasource)) {
            return getHiveQueryToolInstance(jobDatasource);
        } else if (JdbcConstant.CLICKHOUSE.equals(datasource)) {
            return getClickHouseQueryToolInstance(jobDatasource);
        } else if (JdbcConstant.HBASE20XSQL.equals(datasource)) {
            return getHbase20XsqlQueryToolQueryToolInstance(jobDatasource);
        } else if (JdbcConstant.HANA.equals(datasource)) {
            return getHanaQueryToolInstance(jobDatasource);
        }
        throw new UnsupportedOperationException("找不到该类型: ".concat(datasource));
    }

    private static BaseQueryTool getMySQLQueryToolInstance(DatasourceDto jdbcDatasource) {
        try {
            return new MySQLQueryTool(jdbcDatasource);
        } catch (Exception e) {
            log.error("getMySQLQueryToolInstance error :" , e);
            Asserts.fail("数据库操作异常");
        }
        return null;
    }

    private static BaseQueryTool getOracleQueryToolInstance(DatasourceDto jdbcDatasource) {
        try {
            return new OracleQueryTool(jdbcDatasource);
        } catch (SQLException e) {
            log.error("getOracleQueryToolInstance error :" , e);
            Asserts.fail("数据库操作异常");
        }
        return null;
    }

    private static BaseQueryTool getPostgresqlQueryToolInstance(DatasourceDto jdbcDatasource) {
        try {
            return new PostgresqlQueryTool(jdbcDatasource);
        } catch (SQLException e) {
            log.error("getPostgresqlQueryToolInstance error :" , e);
            Asserts.fail("数据库操作异常");
        }
        return null;
    }

    private static BaseQueryTool getSqlserverQueryToolInstance(DatasourceDto jdbcDatasource) {
        try {
            return new SqlServerQueryTool(jdbcDatasource);
        } catch (SQLException e) {
            log.error("getSqlserverQueryToolInstance error :" , e);
            Asserts.fail("数据库操作异常");
        }
        return null;
    }

    private static BaseQueryTool getHiveQueryToolInstance(DatasourceDto jdbcDatasource) {
        try {
            return new HiveQueryTool(jdbcDatasource);
        } catch (SQLException e) {
            log.error("getHiveQueryToolInstance error :" , e);
            Asserts.fail("数据库操作异常");
        }
        return null;
    }
    private static BaseQueryTool getClickHouseQueryToolInstance(DatasourceDto jdbcDatasource) {
        try {
            return new ClickHouseQueryTool(jdbcDatasource);
        } catch (SQLException e) {
            log.error("getClickHouseQueryToolInstance error :" , e);
            Asserts.fail("数据库操作异常");
        }
        return null;
    }
    private static BaseQueryTool getHanaQueryToolInstance(DatasourceDto jdbcDatasource) {
        try {
            return new HanaQueryTool(jdbcDatasource);
        } catch (SQLException e) {
            log.error("getHanaQueryToolInstance error :" , e);
            Asserts.fail("数据库操作异常");
        }
        return null;
    }
    private static Hbase20XsqlQueryTool getHbase20XsqlQueryToolQueryToolInstance(DatasourceDto jdbcDatasource) {
        try {
            return new Hbase20XsqlQueryTool(jdbcDatasource);
        } catch (SQLException e) {
            log.error("getHbase20XsqlQueryToolQueryToolInstance error :" , e);
            Asserts.fail("数据库操作异常");
        }
        return null;
    }
}
