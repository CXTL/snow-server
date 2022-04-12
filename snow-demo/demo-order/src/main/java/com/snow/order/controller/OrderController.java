package com.snow.order.controller;


import com.snow.core.dto.demo.OrderDto;
import com.snow.core.dto.demo.OrderParam;
import com.snow.mybatis.CommonResult;
import com.snow.order.service.OrderService;
import com.snow.page.CommonPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xt
 * @since 2022-04-12
 */
@Api(tags = "订单API")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("根据订单ID获取订单信息")
    @GetMapping(value = "findOrderById")
    public CommonResult<OrderDto> findOrderById(@RequestParam(value = "orderId") Integer orderId) {
        return CommonResult.success(orderService.findOrderById(orderId));
    }

    @ApiOperation("新增订单")
    @PostMapping(value = "add")
    public CommonResult<Integer> add(@RequestBody OrderParam orderParam) {
        return CommonResult.success(orderService.add(orderParam));
    }

    @ApiOperation("修改订单")
    @PostMapping(value = "update")
    public CommonResult<Integer> update(@RequestBody OrderParam orderParam) {
        return CommonResult.success(orderService.update(orderParam));
    }

    @ApiOperation("删除订单")
    @PostMapping(value = "delete")
    public CommonResult<Integer> delete(@RequestParam(value = "orderId") Long orderId) {
        return CommonResult.success(orderService.delete(orderId));
    }

    @ApiOperation("订单列表")
    @GetMapping(value = "listOrder")
    public CommonResult<List<OrderDto>> listOrder() {
        return CommonResult.success(orderService.listOrder());
    }

    @ApiOperation("分页订单列表")
    @PostMapping(value = "pageListOrder")
    public CommonResult<CommonPage<OrderDto>> pageListOrder(
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OrderDto> OrderList = orderService.pageListOrder(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(OrderList));
    }

}

