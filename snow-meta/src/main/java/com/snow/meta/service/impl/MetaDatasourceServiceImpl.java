package com.snow.meta.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.snow.core.dto.meta.DatasourceDto;
import com.snow.core.dto.meta.DatasourceParam;
import com.snow.core.enums.JdbcTypeEnum;
import com.snow.core.exception.Asserts;
import com.snow.meta.entity.MetaDatasourceInfo;
import com.snow.meta.mapper.MetaDatasourceMapper;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer add(DatasourceParam datasourceParam) {
        MetaDatasourceInfo metaDatasourceInfo = MetaDatasourceInfo.builder().build();
        BeanUtils.copyProperties(datasourceParam ,metaDatasourceInfo);
        checkDatasourceNameUnique(metaDatasourceInfo);
        JdbcTypeEnum jdbcTypeEnum = JdbcTypeEnum.transform(datasourceParam.getType());
        if(Objects.nonNull(jdbcTypeEnum)){
            metaDatasourceInfo.setDriverClassName(jdbcTypeEnum.getDriver());
        }
        metaDatasourceInfo.setCreateTime(LocalDateTime.now());
        metaDatasourceInfo.setUpdateTime(metaDatasourceInfo.getCreateTime());
        return metaDatasourceMapper.insert(metaDatasourceInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer update(DatasourceParam datasourceParam) {
        MetaDatasourceInfo oldDatasourceInfo = metaDatasourceMapper.selectById(datasourceParam.getId());
        if(Objects.isNull(oldDatasourceInfo)){
            Asserts.fail("数据源信息不存在");
        }
        MetaDatasourceInfo metaDatasourceInfo = MetaDatasourceInfo.builder().build();
        BeanUtils.copyProperties(datasourceParam ,metaDatasourceInfo);
        checkDatasourceNameUnique(metaDatasourceInfo);
        if(oldDatasourceInfo.getType().compareTo(metaDatasourceInfo.getType()) != 0){
            JdbcTypeEnum jdbcTypeEnum = JdbcTypeEnum.transform(datasourceParam.getType());
            if(Objects.nonNull(jdbcTypeEnum)){
                metaDatasourceInfo.setDriverClassName(jdbcTypeEnum.getDriver());
            }
        }
        metaDatasourceInfo.setUpdateTime(LocalDateTime.now());
        return metaDatasourceMapper.updateById(metaDatasourceInfo);
    }


    @Override
    public Integer delete(Long DatasourceId) {
        return metaDatasourceMapper.deleteById(DatasourceId);
    }

    @Override
    public DatasourceDto findDatasourceById(Long DatasourceId) {
        MetaDatasourceInfo metaDatasourceInfo = metaDatasourceMapper.selectById(DatasourceId);
        if(Objects.isNull(metaDatasourceInfo)){
            Asserts.fail("数据源信息不存在");
        }
        DatasourceDto datasourceDto = DatasourceDto.builder().build();
        BeanUtils.copyProperties(metaDatasourceInfo, datasourceDto);
        return datasourceDto;
    }

    @Override
    public List<DatasourceDto> listDatasource() {
        List<MetaDatasourceInfo> metaDatasourceInfos = metaDatasourceMapper.selectList(new LambdaQueryWrapper<>());
        return metaDatasourceInfos.stream().map(a->{
            DatasourceDto datasourceDto = DatasourceDto.builder().build();
            BeanUtils.copyProperties(a, datasourceDto);
            return datasourceDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<DatasourceDto> pageListDatasource(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return  metaDatasourceMapper.listDatasourceByPage();
    }

    private void checkDatasourceNameUnique(MetaDatasourceInfo datasourceInfo){
        MetaDatasourceInfo metaDatasourceInfo = metaDatasourceMapper.selectOne(
                new LambdaQueryWrapper<MetaDatasourceInfo>()
                        .eq(MetaDatasourceInfo::getDatasourceName, datasourceInfo.getDatasourceName()));
        if(Objects.nonNull(metaDatasourceInfo)){
            Asserts.fail("数据源名称重复");
        }
    }

}
