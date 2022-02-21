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

    public static BaseQueryTool getByDbType(DatasourceDto datasourceDto) {
        //获取dbType
        String datasource = datasourceDto.getType();
        if (JdbcConstant.MYSQL.equals(datasource)) {
            return getMySQLQueryToolInstance(datasourceDto);
        } else if (JdbcConstant.ORACLE.equals(datasource)) {
            return getOracleQueryToolInstance(datasourceDto);
        } else if (JdbcConstant.POSTGRESQL.equals(datasource)) {
            return getPostgresqlQueryToolInstance(datasourceDto);
        } else if (JdbcConstant.SQL_SERVER.equals(datasource)) {
            return getSqlserverQueryToolInstance(datasourceDto);
        } else if (JdbcConstant.HIVE.equals(datasource)) {
            return getHiveQueryToolInstance(datasourceDto);
        } else if (JdbcConstant.CLICKHOUSE.equals(datasource)) {
            return getClickHouseQueryToolInstance(datasourceDto);
        } else if (JdbcConstant.HBASE20XSQL.equals(datasource)) {
            return getHbase20XsqlQueryToolQueryToolInstance(datasourceDto);
        } else if (JdbcConstant.HANA.equals(datasource)) {
            return getHanaQueryToolInstance(datasourceDto);
        }
        throw new UnsupportedOperationException("找不到该类型: ".concat(datasource));
    }

    private static BaseQueryTool getMySQLQueryToolInstance(DatasourceDto datasourceDto) {
        try {
            return new MySQLQueryTool(datasourceDto);
        } catch (Exception e) {
            log.error("getMySQLQueryToolInstance error :" , e);
            Asserts.fail("数据库操作异常");
        }
        return null;
    }

    private static BaseQueryTool getOracleQueryToolInstance(DatasourceDto datasourceDto) {
        try {
            return new OracleQueryTool(datasourceDto);
        } catch (SQLException e) {
            log.error("getOracleQueryToolInstance error :" , e);
            Asserts.fail("数据库操作异常");
        }
        return null;
    }

    private static BaseQueryTool getPostgresqlQueryToolInstance(DatasourceDto datasourceDto) {
        try {
            return new PostgresqlQueryTool(datasourceDto);
        } catch (SQLException e) {
            log.error("getPostgresqlQueryToolInstance error :" , e);
            Asserts.fail("数据库操作异常");
        }
        return null;
    }

    private static BaseQueryTool getSqlserverQueryToolInstance(DatasourceDto datasourceDto) {
        try {
            return new SqlServerQueryTool(datasourceDto);
        } catch (SQLException e) {
            log.error("getSqlserverQueryToolInstance error :" , e);
            Asserts.fail("数据库操作异常");
        }
        return null;
    }

    private static BaseQueryTool getHiveQueryToolInstance(DatasourceDto datasourceDto) {
        try {
            return new HiveQueryTool(datasourceDto);
        } catch (SQLException e) {
            log.error("getHiveQueryToolInstance error :" , e);
            Asserts.fail("数据库操作异常");
        }
        return null;
    }
    private static BaseQueryTool getClickHouseQueryToolInstance(DatasourceDto datasourceDto) {
        try {
            return new ClickHouseQueryTool(datasourceDto);
        } catch (SQLException e) {
            log.error("getClickHouseQueryToolInstance error :" , e);
            Asserts.fail("数据库操作异常");
        }
        return null;
    }
    private static BaseQueryTool getHanaQueryToolInstance(DatasourceDto datasourceDto) {
        try {
            return new HanaQueryTool(datasourceDto);
        } catch (SQLException e) {
            log.error("getHanaQueryToolInstance error :" , e);
            Asserts.fail("数据库操作异常");
        }
        return null;
    }
    private static Hbase20XsqlQueryTool getHbase20XsqlQueryToolQueryToolInstance(DatasourceDto datasourceDto) {
        try {
            return new Hbase20XsqlQueryTool(datasourceDto);
        } catch (SQLException e) {
            log.error("getHbase20XsqlQueryToolQueryToolInstance error :" , e);
            Asserts.fail("数据库操作异常");
        }
        return null;
    }
}
