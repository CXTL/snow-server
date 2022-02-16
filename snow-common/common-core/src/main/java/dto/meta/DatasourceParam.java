package dto.meta;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DatasourceParam {

    private Long id;
    /**
     *数据源名称
     */
    private String datasourceName;
    /**
     *数据库名称
     */
    private String databaseName;
    /**
     *schema名称
     */
    private String schemaName;
    /**
     *数据驱动名称
     */
    private String driverClassName;
    /**
     *连接数据库地址
     */
    private String url;
    /**
     *用户名
     */
    private String username;
    /**
     *密码
     */
    private String password;
    /**
     *ip地址
     */
    private String ip;
    /**
     *端口
     */
    private String port;
    /**
     *数据源类型 mysql oracle pgsql hive hbase
     */
    private String type;
    /**
     *备注
     */
    private String description;
}
