package com.snow.meta.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.snow.core.dto.meta.DatasourceDto;
import com.snow.core.dto.meta.DatasourceParam;
import com.snow.core.enums.JdbcTypeEnum;
import com.snow.core.enums.SyncStatusEnum;
import com.snow.core.exception.Asserts;
import com.snow.meta.entity.MetaDatasourceInfo;
import com.snow.meta.mapper.MetaDatasourceMapper;
import com.snow.meta.query.BaseQueryTool;
import com.snow.meta.query.QueryToolFactory;
import com.snow.meta.service.AsyncService;
import com.snow.meta.service.MetaDatasourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MetaDatasourceServiceImpl implements MetaDatasourceService {

    @Autowired
    private MetaDatasourceMapper metaDatasourceMapper;

    @Autowired
    private AsyncService asyncService;


    /**
     * 新增数据源
     *
     * @param datasourceParam
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer add(DatasourceParam datasourceParam) {
        MetaDatasourceInfo metaDatasourceInfo = MetaDatasourceInfo.builder().build();
        BeanUtils.copyProperties(datasourceParam, metaDatasourceInfo);
        checkDatasourceNameUnique(metaDatasourceInfo);
        JdbcTypeEnum jdbcTypeEnum = JdbcTypeEnum.transform(datasourceParam.getType());
        if (Objects.nonNull(jdbcTypeEnum)) {
            metaDatasourceInfo.setDriverClassName(jdbcTypeEnum.getDriver());
        }
        metaDatasourceInfo.setCreateTime(LocalDateTime.now());
        metaDatasourceInfo.setUpdateTime(metaDatasourceInfo.getCreateTime());
        return metaDatasourceMapper.insert(metaDatasourceInfo);
    }

    /**
     * 修改数据源
     *
     * @param datasourceParam
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer update(DatasourceParam datasourceParam) {
        getDatabaseSourceById(datasourceParam.getId());
        MetaDatasourceInfo metaDatasourceInfo = MetaDatasourceInfo.builder().build();
        BeanUtils.copyProperties(datasourceParam, metaDatasourceInfo);
        checkDatasourceNameUnique(metaDatasourceInfo);
        JdbcTypeEnum jdbcTypeEnum = JdbcTypeEnum.transform(datasourceParam.getType());
        if (Objects.nonNull(jdbcTypeEnum)) {
            metaDatasourceInfo.setDriverClassName(jdbcTypeEnum.getDriver());
        }
        metaDatasourceInfo.setUpdateTime(LocalDateTime.now());
        return metaDatasourceMapper.updateById(metaDatasourceInfo);
    }


    /**
     * 删除数据源
     *
     * @param DatasourceId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer delete(Long DatasourceId) {
        return metaDatasourceMapper.deleteById(DatasourceId);
    }

    /**
     * 根据ID查询数据源信息
     *
     * @param datasourceId
     * @return
     */
    @Override
    public DatasourceDto findDatasourceById(Long datasourceId) {
        MetaDatasourceInfo metaDatasourceInfo = getDatabaseSourceById(datasourceId);
        DatasourceDto datasourceDto = DatasourceDto.builder().build();
        BeanUtils.copyProperties(metaDatasourceInfo, datasourceDto);
        return datasourceDto;
    }

    /**
     * 数据源信息列表
     *
     * @return
     */
    @Override
    public List<DatasourceDto> listDatasource() {
        List<MetaDatasourceInfo> metaDatasourceInfos = metaDatasourceMapper.selectList(new LambdaQueryWrapper<>());
        return metaDatasourceInfos.stream().map(a -> {
            DatasourceDto datasourceDto = DatasourceDto.builder().build();
            BeanUtils.copyProperties(a, datasourceDto);
            return datasourceDto;
        }).collect(Collectors.toList());
    }

    /**
     * 分页查询数据源信息
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public List<DatasourceDto> pageListDatasource(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return metaDatasourceMapper.listDatasourceByPage();
    }

    /**
     * 测试连接
     *
     * @param datasourceId
     * @return
     */
    @Override
    public Boolean connect(Long datasourceId) {
        MetaDatasourceInfo datasourceInfo = getDatabaseSourceById(datasourceId);
        DatasourceDto datasourceDto = new DatasourceDto();
        BeanUtils.copyProperties(datasourceInfo, datasourceDto);
        BaseQueryTool queryTool = QueryToolFactory.getByDbType(datasourceDto);
        if (!queryTool.dataSourceTest()) {
            Asserts.fail("连接失败");
        }
        return true;
    }

    /**
     * 数据同步 实际执行的同步逻辑为 actualSync 方法
     *
     * @param datasourceId
     */
    @Override
    public void sync(Long datasourceId) {
        //修改状态为同步中
        MetaDatasourceInfo metaDatasourceInfo = getDatabaseSourceById(datasourceId);
        Integer syncStatus = metaDatasourceInfo.getSyncStatus();
        if (SyncStatusEnum.SYNC_ING.getStatus().equals(syncStatus)) {
            Asserts.fail("正在同步中,请勿重复操作!");
        }
        metaDatasourceInfo.setSyncStatus(SyncStatusEnum.SYNC_ING.getStatus());
        metaDatasourceMapper.updateById(metaDatasourceInfo);
        //异步同步数据
        asyncService.actualSync(metaDatasourceInfo);
    }


    /**
     * 检查数据源名称重复
     *
     * @param datasourceInfo
     */
    private void checkDatasourceNameUnique(MetaDatasourceInfo datasourceInfo) {
        MetaDatasourceInfo metaDatasourceInfo = metaDatasourceMapper.selectOne(
                new LambdaQueryWrapper<MetaDatasourceInfo>()
                        .eq(MetaDatasourceInfo::getDatasourceName, datasourceInfo.getDatasourceName()));
        if (Objects.nonNull(metaDatasourceInfo)) {
            Asserts.fail("数据源名称重复");
        }
    }

    /**
     * 获取数据源信息
     *
     * @param datasourceId
     * @return
     */
    private MetaDatasourceInfo getDatabaseSourceById(Long datasourceId) {
        MetaDatasourceInfo metaDatasourceInfo = metaDatasourceMapper.selectById(datasourceId);
        if (Objects.isNull(metaDatasourceInfo)) {
            Asserts.fail("数据源信息不存在");
        }
        return metaDatasourceInfo;
    }


    /**
     * 获取查询工具
     *
     * @param datasourceInfo
     * @return
     */
    public static BaseQueryTool getQueryToolByDsInfo(MetaDatasourceInfo datasourceInfo) {
        DatasourceDto datasourceDto = new DatasourceDto();
        BeanUtils.copyProperties(datasourceInfo, datasourceDto);
        BaseQueryTool queryTool = QueryToolFactory.getByDbType(datasourceDto);
        return queryTool;
    }
}
