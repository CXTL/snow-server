package com.snow.meta.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.snow.meta.entity.MetaDatasourceInfo;
import com.snow.meta.mapper.MetaDatasourceMapper;
import com.snow.meta.service.MetaDatasourceService;
import dto.meta.DatasourceDto;
import dto.meta.DatasourceParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetaDatasourceServiceImpl implements MetaDatasourceService {

    @Autowired
    private MetaDatasourceMapper metaDatasourceMapper;

    @Override
    public Integer add(DatasourceParam datasourceParam) {
        MetaDatasourceInfo metaDatasourceInfo = MetaDatasourceInfo.builder().build();
        BeanUtils.copyProperties(datasourceParam ,metaDatasourceInfo);
        metaDatasourceInfo.setCreateTime(LocalDateTime.now());
        return metaDatasourceMapper.insert(metaDatasourceInfo);
    }

    @Override
    public Integer update(DatasourceParam datasourceParam) {
        MetaDatasourceInfo metaDatasourceInfo = MetaDatasourceInfo.builder().build();
        BeanUtils.copyProperties(datasourceParam ,metaDatasourceInfo);
        return metaDatasourceMapper.updateById(metaDatasourceInfo);
    }

    @Override
    public Integer delete(Long DatasourceId) {
        return metaDatasourceMapper.deleteById(DatasourceId);
    }

    @Override
    public DatasourceDto findDatasourceById(Long DatasourceId) {
        MetaDatasourceInfo metaDatasourceInfo = metaDatasourceMapper.selectById(DatasourceId);
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

}
