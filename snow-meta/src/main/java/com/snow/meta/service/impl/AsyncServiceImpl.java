package com.snow.meta.service.impl;

import com.alibaba.nacos.common.utils.CollectionUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.snow.core.dto.meta.ColumnInfo;
import com.snow.core.dto.meta.TableInfo;
import com.snow.core.enums.SyncStatusEnum;
import com.snow.core.enums.YesNoEnum;
import com.snow.core.exception.Asserts;
import com.snow.meta.config.AsyncConfig;
import com.snow.meta.entity.MetaDatasourceInfo;
import com.snow.meta.entity.MetaFieldInfo;
import com.snow.meta.entity.MetaTableInfo;
import com.snow.meta.mapper.MetaDatasourceMapper;
import com.snow.meta.mapper.MetaFieldMapper;
import com.snow.meta.mapper.MetaTableMapper;
import com.snow.meta.query.BaseQueryTool;
import com.snow.meta.service.AsyncService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.snow.meta.service.impl.MetaDatasourceServiceImpl.getQueryToolByDsInfo;

@Service
public class AsyncServiceImpl implements AsyncService {

    @Autowired
    private MetaDatasourceMapper metaDatasourceMapper;

    @Autowired
    private MetaTableMapper metaTableMapper;

    @Autowired
    private MetaFieldMapper metaFieldMapper;

    @Override
    /**
     * 实际操作的同步数据
     *
     * @param datasourceInfo    数据源信息
     * @return
     */
    @Async(AsyncConfig.EXECUTOR_NAME)
    @Transactional(rollbackFor = Exception.class)
    public void actualSync(MetaDatasourceInfo datasourceInfo) {
        List<MetaTableInfo> metaTableInfos = metaTableMapper.selectList(new LambdaQueryWrapper<MetaTableInfo>()
                .eq(MetaTableInfo::getDatasourceId, datasourceInfo.getId()));
        try {
            if (CollectionUtils.isNotEmpty(metaTableInfos)) {
                metaTableMapper.deleteByDsId(datasourceInfo.getId());
                List<Long> tableIds = metaTableInfos.stream().map(MetaTableInfo::getId).collect(Collectors.toList());
                metaFieldMapper.deleteByTableIds(tableIds);
            }
            BaseQueryTool queryTool = getQueryToolByDsInfo(datasourceInfo);
            //查询表数据
            List<TableInfo> tables = queryTool.getTables();
            LocalDateTime now = LocalDateTime.now();
            if (CollectionUtils.isNotEmpty(tables)) {
                tables.stream().forEach(a -> {
                    MetaTableInfo tableInfo = new MetaTableInfo();
                    BeanUtils.copyProperties(a, tableInfo);
                    tableInfo.setDatasourceId(datasourceInfo.getId());
                    tableInfo.setDatabaseName(datasourceInfo.getDatabaseName());
                    tableInfo.setCreateTime(now);
                    tableInfo.setUpdateTime(now);
                    tableInfo.setDeleted(YesNoEnum.NO.getValue());
                    metaTableMapper.insert(tableInfo);
                    //保存表字段信息
                    saveFiledInfo(queryTool, tableInfo, now);
                });
            }
            datasourceInfo.setSyncStatus(SyncStatusEnum.SYNC_SUCCESS.getStatus());
        } catch (Exception e) {
            datasourceInfo.setSyncStatus(SyncStatusEnum.SYNC_FALSE.getStatus());
            Asserts.fail("同步失败");
        } finally {
            metaDatasourceMapper.updateById(datasourceInfo);
        }
    }


    /**
     * 批量保存字段信息
     *
     * @param queryTool 查询工具
     * @param tableInfo 表信息
     * @param now       时间
     */
    private void saveFiledInfo(BaseQueryTool queryTool, MetaTableInfo tableInfo, LocalDateTime now) {
        //查询表字段信息
        List<ColumnInfo> columns = queryTool.getColumns(tableInfo.getTableName());
        if (CollectionUtils.isNotEmpty(columns)) {
            List<MetaFieldInfo> metaFieldInfos = columns.stream().map(a -> {
                MetaFieldInfo fieldInfo = new MetaFieldInfo();
                BeanUtils.copyProperties(a, fieldInfo);
                fieldInfo.setCreateTime(now);
                fieldInfo.setUpdateTime(now);
                fieldInfo.setTableId(tableInfo.getId());
                fieldInfo.setPrimaryKeyFlag(a.getIfPrimaryKey() ? YesNoEnum.YES.getValue() : YesNoEnum.NO.getValue());
                fieldInfo.setNullFlag(a.getIsnull());
                fieldInfo.setDeleted(YesNoEnum.NO.getValue());
                return fieldInfo;
            }).collect(Collectors.toList());
            metaFieldMapper.batchInsert(metaFieldInfos);
        }


    }
}
