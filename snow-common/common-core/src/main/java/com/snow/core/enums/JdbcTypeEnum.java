package com.snow.core.enums;

import com.snow.core.constant.JdbcConstant;
import lombok.Getter;

/**
 * @Description 检查类型枚举
 */
@Getter
public enum JdbcTypeEnum {

    MYSQL(JdbcConstant.MYSQL, JdbcConstant.MYSQL_DRIVER),
    POSTGRESQL(JdbcConstant.POSTGRESQL, JdbcConstant.POSTGRESQL_DRIVER),
    SQL_SERVER(JdbcConstant.SQL_SERVER, JdbcConstant.SQL_SERVER_DRIVER),
    ORACLE(JdbcConstant.ORACLE, JdbcConstant.ORACLE_DRIVER),
    HANA(JdbcConstant.HANA, JdbcConstant.HANA_DRIVER),
    HIVE(JdbcConstant.HIVE, JdbcConstant.HIVE_DRIVER),
    CLICKHOUSE(JdbcConstant.CLICKHOUSE, JdbcConstant.CLICKHOUSE_DRIVER),
    HBASE20XSQL(JdbcConstant.HBASE20XSQL, JdbcConstant.HBASE20XSQL_DRIVER),

    ;

    private final String value;

    private final String driver;

    JdbcTypeEnum(String value, String driver) {
        this.value = value;
        this.driver = driver;
    }


    /**
     * 枚举转换
     */
    public static JdbcTypeEnum transform(String jdbcType) {
        for (JdbcTypeEnum temp : JdbcTypeEnum.values()) {
            if (temp.getValue().equals(jdbcType)) {
                return temp;
            }
        }
        return null;
    }


}
