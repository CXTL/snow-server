package com.snow.meta.controller;

import api.CommonPage;
import api.CommonResult;
import com.snow.meta.service.MetaDatasourceService;
import dto.meta.DatasourceDto;
import dto.meta.DatasourceParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "datasource")
public class MetaDatasourceController {

    @Autowired
    private MetaDatasourceService metaDatasourceService;

    @GetMapping(value = "findDatasourceById")
    public CommonResult<DatasourceDto> findDatasourceById(@RequestParam(value = "datasourceId") Long datasourceId) {
        return CommonResult.success(metaDatasourceService.findDatasourceById(datasourceId));
    }

    @PostMapping(value = "add")
    public CommonResult<Integer> add(@RequestBody DatasourceParam datasourceParam) {
        return CommonResult.success(metaDatasourceService.add(datasourceParam));
    }

    @PostMapping(value = "update")
    public CommonResult<Integer> update(@RequestBody DatasourceParam datasourceParam) {
        return CommonResult.success(metaDatasourceService.update(datasourceParam));
    }

    @PostMapping(value = "delete")
    public CommonResult<Integer> delete(@RequestParam(value = "datasourceId") Long datasourceId) {
        return CommonResult.success(metaDatasourceService.delete(datasourceId));
    }

    @GetMapping(value = "listDatasource")
    public CommonResult<List<DatasourceDto>> listDatasource() {
        return CommonResult.success(metaDatasourceService.listDatasource());
    }

    @PostMapping(value = "pageListDatasource")
    public CommonResult<CommonPage<DatasourceDto>> pageListDatasource(
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<DatasourceDto> DatasourceList = metaDatasourceService.pageListDatasource(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(DatasourceList));
    }


}
