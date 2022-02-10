package com.snow.meta.meta;


import constant.JdbcConstant;

/**
 * meta信息工厂
 *
 */
public class DatabaseMetaFactory {

    //根据数据库类型返回对应的接口
    public static DatabaseInterface getByDbType(String dbType) {
        if (JdbcConstant.MYSQL.equals(dbType)) {
            return MySQLDatabaseMeta.getInstance();
        } else if (JdbcConstant.ORACLE.equals(dbType)) {
            return OracleDatabaseMeta.getInstance();
        } else if (JdbcConstant.POSTGRESQL.equals(dbType)) {
            return PostgresqlDatabaseMeta.getInstance();
        } else if (JdbcConstant.SQL_SERVER.equals(dbType)) {
            return SqlServerDatabaseMeta.getInstance();
        } else if (JdbcConstant.HIVE.equals(dbType)) {
            return HiveDatabaseMeta.getInstance();
        }else if(JdbcConstant.CLICKHOUSE.equals(dbType)) {
            return ClickHouseDataBaseMeta.getInstance();
        } else if(JdbcConstant.HBASE20XSQL.equals(dbType)) {
            return Hbase20xsqlMeta.getInstance();
        } else if(JdbcConstant.HANA.equals(dbType)) {
            return HanaDatabaseMeta.getInstance();
        } else {
            throw new UnsupportedOperationException("暂不支持的类型：".concat(dbType));
        }
    }
}
