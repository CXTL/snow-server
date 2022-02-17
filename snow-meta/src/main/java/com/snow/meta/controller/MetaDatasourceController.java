package com.snow.meta.controller;

import com.snow.page.CommonPage;
import com.snow.mybatis.CommonResult;
import com.snow.meta.service.MetaDatasourceService;
import com.snow.core.dto.meta.DatasourceDto;
import com.snow.core.dto.meta.DatasourceParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "数据源API")
@RestController
@RequestMapping(value = "datasource")
public class MetaDatasourceController {

    @Autowired
    private MetaDatasourceService metaDatasourceService;

    @ApiOperation("根据数据源ID获取数据源信息")
    @GetMapping(value = "findDatasourceById")
    public CommonResult<DatasourceDto> findDatasourceById(@RequestParam(value = "datasourceId") Long datasourceId) {
        return CommonResult.success(metaDatasourceService.findDatasourceById(datasourceId));
    }

    @ApiOperation("新增数据源")
    @PostMapping(value = "add")
    public CommonResult<Integer> add(@RequestBody DatasourceParam datasourceParam) {
        return CommonResult.success(metaDatasourceService.add(datasourceParam));
    }

    @ApiOperation("修改数据源")
    @PostMapping(value = "update")
    public CommonResult<Integer> update(@RequestBody DatasourceParam datasourceParam) {
        return CommonResult.success(metaDatasourceService.update(datasourceParam));
    }

    @ApiOperation("删除数据源")
    @PostMapping(value = "delete")
    public CommonResult<Integer> delete(@RequestParam(value = "datasourceId") Long datasourceId) {
        return CommonResult.success(metaDatasourceService.delete(datasourceId));
    }

    @ApiOperation("数据源列表")
    @GetMapping(value = "listDatasource")
    public CommonResult<List<DatasourceDto>> listDatasource() {
        return CommonResult.success(metaDatasourceService.listDatasource());
    }

    @ApiOperation("分页数据源列表")
    @PostMapping(value = "pageListDatasource")
    public CommonResult<CommonPage<DatasourceDto>> pageListDatasource(
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<DatasourceDto> DatasourceList = metaDatasourceService.pageListDatasource(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(DatasourceList));
    }


}
