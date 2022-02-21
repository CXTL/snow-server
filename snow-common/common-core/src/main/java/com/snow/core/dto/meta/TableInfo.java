package com.snow.core.dto.meta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 表信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TableInfo {
    /**
     * 表名
     */
    private String tableName;

    /**
     * 注释
     */
    private String description;

    /**
     * 数据库名称
     */
    private String databaseName;
    /**
     * schema名称
     */
    private String schemaName;

    /**
     * 数据表中文名称
     */
    private String tableNameChinese;

    /**
     * 数据源类型  0:表 1:视图，2:SQL 3:代码表
     */
    private Integer type;

    /**
     * 所有列
     */
    private List<ColumnInfo> columns;
}
