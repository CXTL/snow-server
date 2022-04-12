package com.snow.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.snow.core.dto.demo.OrderDto;
import com.snow.core.dto.demo.OrderParam;
import com.snow.order.entity.Order;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xt
 * @since 2022-04-12
 */
public interface OrderService extends IService<Order> {

    OrderDto findOrderById(Integer orderId);

    Integer add(OrderParam orderParam);

    Integer update(OrderParam orderParam);

    Integer delete(Long OrderId);

    List<OrderDto> listOrder();

    List<OrderDto> pageListOrder(Integer pageSize, Integer pageNum);

}
