package com.snow.meta.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;
import com.snow.meta.query.BaseQueryTool;
import com.snow.meta.query.QueryToolFactory;
import com.snow.meta.service.DatasourceQueryService;
import com.snow.core.constant.JdbcConstant;
import com.snow.core.dto.meta.DatasourceDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * datasource query
 *
 */
@Service
public class DatasourceQueryServiceImpl implements DatasourceQueryService {

    @Autowired
    private MetaDatasourceServiceImpl jobDatasourceService;

    @Override
    public List<String> getDBs(Long id) throws IOException {
        //获取数据源对象
        DatasourceDto datasource = jobDatasourceService.findDatasourceById(id);
//        return new MongoDBQueryTool(datasource).getDBNames();
        return null;
    }


    @Override
    public List<String> getTables(Long id, String tableSchema) {
        //获取数据源对象
        DatasourceDto datasource = jobDatasourceService.findDatasourceById(id);
        //queryTool组装
        if (ObjectUtil.isNull(datasource)) {
            return Lists.newArrayList();
        }
        if (JdbcConstant.HBASE.equals(datasource.getType())) {
//            return new HBaseQueryTool(datasource).getTableNames();
        } else if (JdbcConstant.MONGODB.equals(datasource.getType())) {
//            return new MongoDBQueryTool(datasource).getCollectionNames(datasource.getDatabaseName());
        } else {
            BaseQueryTool qTool = QueryToolFactory.getByDbType(datasource);
            if(StringUtils.isBlank(tableSchema)){
                return qTool.getTableNames();
            }else{
                return qTool.getTableNames(tableSchema);
            }
        }
        return null;
    }

    @Override
    public List<String> getTableSchema(Long id) {
        //获取数据源对象
        DatasourceDto datasource = jobDatasourceService.findDatasourceById(id);
        //queryTool组装
        if (ObjectUtil.isNull(datasource)) {
            return Lists.newArrayList();
        }
        BaseQueryTool qTool = QueryToolFactory.getByDbType(datasource);
        return qTool.getTableSchema();
    }

    @Override
    public List<String> getCollectionNames(long id, String dbName) throws IOException {
        //获取数据源对象
        DatasourceDto datasource = jobDatasourceService.findDatasourceById(id);
        //queryTool组装
        if (ObjectUtil.isNull(datasource)) {
            return Lists.newArrayList();
        }
//        return new MongoDBQueryTool(datasource).getCollectionNames(dbName);
        return null;
    }


    @Override
    public List<String> getColumns(Long id, String tableName) throws IOException {
        //获取数据源对象
        DatasourceDto datasource = jobDatasourceService.findDatasourceById(id);
        //queryTool组装
        if (ObjectUtil.isNull(datasource)) {
            return Lists.newArrayList();
        }
        if (JdbcConstant.HBASE.equals(datasource.getType())) {
//            return new HBaseQueryTool(datasource).getColumns(tableName);
        } else if (JdbcConstant.MONGODB.equals(datasource.getType())) {
//            return new MongoDBQueryTool(datasource).getColumns(tableName);
        } else {
            BaseQueryTool queryTool = QueryToolFactory.getByDbType(datasource);
            return queryTool.getColumnNames(tableName, datasource.getType());
        }
        return null;
    }

    @Override
    public List<String> getColumnsByQuerySql(Long datasourceId, String querySql) throws SQLException {
        //获取数据源对象
        DatasourceDto jdbcDatasource = jobDatasourceService.findDatasourceById(datasourceId);
        //queryTool组装
        if (ObjectUtil.isNull(jdbcDatasource)) {
            return Lists.newArrayList();
        }
        BaseQueryTool queryTool = QueryToolFactory.getByDbType(jdbcDatasource);
        return queryTool.getColumnsByQuerySql(querySql);
    }
}
