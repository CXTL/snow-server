package com.snow.meta.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MetaTableInfo {


    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     *数据源ID
     */
    private Long datasourceId;
    /**
     *数据库名称
     */
    private String databaseName;
    /**
     *schema名称
     */
    private String schemaName;
    /**
     *数据表名称
     */
    private String tableName;
    /**
     *数据表中文名称
     */
    private String tableNameChinese;
    /**
     *数据源类型  0:表 1:视图，2:SQL 3:代码表
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
