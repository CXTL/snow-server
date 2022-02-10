package enums;

import constant.JdbcConstant;
import lombok.Getter;

/**
 * @Description 检查类型枚举
 */
@Getter
public enum JdbcTypeEnum {

    MYSQL(JdbcConstant.MYSQL, "mysql"),
    POSTGRESQL(JdbcConstant.POSTGRESQL, "pgsql"),
    SQL_SERVER(JdbcConstant.SQL_SERVER, "sqlServer"),
    ORACLE(JdbcConstant.ORACLE, "oracle"),
    HANA(JdbcConstant.HANA, "hana"),
    HIVE(JdbcConstant.HIVE, "hive"),
    CLICKHOUSE(JdbcConstant.CLICKHOUSE, "clickHouse"),
    HBASE20XSQL(JdbcConstant.HBASE20XSQL, "hbase"),

    ;

    private final String value;

    private final String description;

    JdbcTypeEnum(String value, String description) {
        this.value = value;
        this.description = description;
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
