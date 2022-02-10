package com.snow.meta.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class MetaDatasourceInfo {

    @TableId(type = IdType.AUTO)
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
     *数据源类型 1:mysql 2:oracle 3:pgsql 4:hive 5:hbase
     */
    private Integer type;
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
