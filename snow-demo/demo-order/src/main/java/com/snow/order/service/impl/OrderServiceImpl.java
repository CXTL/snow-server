package com.snow.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.snow.core.dto.demo.OrderDto;
import com.snow.core.dto.demo.OrderParam;
import com.snow.core.exception.Asserts;
import com.snow.order.entity.Order;
import com.snow.order.mapper.OrderMapper;
import com.snow.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xt
 * @since 2022-04-12
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 新增订单
     *
     * @param orderParam
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer add(OrderParam orderParam) {
        Order order = Order.builder().build();
        BeanUtils.copyProperties(orderParam, order);
        checkOrderNoUnique(order);
        order.setCreateTime(LocalDateTime.now());
        order.setUpdateTime(order.getCreateTime());
        return orderMapper.insert(order);
    }

    /**
     * 修改订单
     *
     * @param orderParam
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer update(OrderParam orderParam) {
        getOrderById(orderParam.getId());
        Order order = Order.builder().build();
        BeanUtils.copyProperties(orderParam, order);
        checkOrderNoUnique(order);
        order.setUpdateTime(LocalDateTime.now());
        return orderMapper.updateById(order);
    }


    /**
     * 删除订单
     *
     * @param OrderId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer delete(Long OrderId) {
        return orderMapper.deleteById(OrderId);
    }

    /**
     * 根据ID查询订单信息
     *
     * @param orderId
     * @return
     */
    @Override
    public OrderDto findOrderById(Integer orderId) {
        Order order = getOrderById(orderId);
        OrderDto orderDto = OrderDto.builder().build();
        BeanUtils.copyProperties(order, orderDto);
        return orderDto;
    }

    /**
     * 订单信息列表
     *
     * @return
     */
    @Override
    public List<OrderDto> listOrder() {
        List<Order> orders = orderMapper.selectList(new LambdaQueryWrapper<>());
        return orders.stream().map(a -> {
            OrderDto orderDto = OrderDto.builder().build();
            BeanUtils.copyProperties(a, orderDto);
            return orderDto;
        }).collect(Collectors.toList());
    }

    /**
     * 分页查询订单信息
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public List<OrderDto> pageListOrder(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return orderMapper.listOrderByPage();
    }

    /**
     * 检查订单编号重复
     *
     * @param orderInfo
     */
    private void checkOrderNoUnique(Order orderInfo) {
        Order order = orderMapper.selectOne(
                new LambdaQueryWrapper<Order>()
                        .eq(Order::getOrderNo, orderInfo.getOrderNo()));
        if (Objects.nonNull(order)) {
            Asserts.fail("订单编号重复");
        }
    }

    /**
     * 获取订单信息
     *
     * @param orderId
     * @return
     */
    private Order getOrderById(Integer orderId) {
        Order order = orderMapper.selectById(orderId);
        if (Objects.isNull(order)) {
            Asserts.fail("订单信息不存在");
        }
        return order;
    }

}
