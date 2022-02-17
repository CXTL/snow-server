package com.snow.core.dto.meta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DatasourceDto {

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
     *数据源状态：1-正常 0-禁用
     */
    private Integer status;
    /**
     *数据源类型 mysql oracle pgsql hive hbase
     */
    private String type;
    /**
     *逻辑删除标识：0-未删除；1-已删除
     */
    private Integer deleted;
    /**
     *创建时间
     */
    private LocalDateTime createTime;
    /**
     *更新时间
     */
    private LocalDateTime updateTime;
    /**
     *备注
     */
    private String description;
}
