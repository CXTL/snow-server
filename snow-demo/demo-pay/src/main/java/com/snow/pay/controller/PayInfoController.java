package com.snow.pay.controller;

import com.snow.core.dto.demo.PayInfoDto;
import com.snow.core.dto.demo.PayInfoParam;
import com.snow.mybatis.CommonResult;
import com.snow.page.CommonPage;
import com.snow.pay.service.PayInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "支付信息API")
@RestController
@RequestMapping(value = "pay")
public class PayInfoController {

    @Autowired
    private PayInfoService payInfoService;

    @ApiOperation("根据支付信息ID获取支付信息信息")
    @GetMapping(value = "findPayInfoById")
    public CommonResult<PayInfoDto> findPayInfoById(@RequestParam(value = "payInfoId") Integer payInfoId) {
        return CommonResult.success(payInfoService.findPayInfoById(payInfoId));
    }

    @ApiOperation("新增支付信息")
    @PostMapping(value = "add")
    public CommonResult<Integer> add(@RequestBody PayInfoParam payInfoParam) {
        return CommonResult.success(payInfoService.add(payInfoParam));
    }

    @ApiOperation("修改支付信息")
    @PostMapping(value = "update")
    public CommonResult<Integer> update(@RequestBody PayInfoParam payInfoParam) {
        return CommonResult.success(payInfoService.update(payInfoParam));
    }

    @ApiOperation("删除支付信息")
    @PostMapping(value = "delete")
    public CommonResult<Integer> delete(@RequestParam(value = "payInfoId") Long payInfoId) {
        return CommonResult.success(payInfoService.delete(payInfoId));
    }

    @ApiOperation("支付信息列表")
    @GetMapping(value = "listPayInfo")
    public CommonResult<List<PayInfoDto>> listPayInfo() {
        return CommonResult.success(payInfoService.listPayInfo());
    }

    @ApiOperation("分页支付信息列表")
    @PostMapping(value = "pageListPayInfo")
    public CommonResult<CommonPage<PayInfoDto>> pageListPayInfo(
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PayInfoDto> PayInfoList = payInfoService.pageListPayInfo(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(PayInfoList));
    }


}
