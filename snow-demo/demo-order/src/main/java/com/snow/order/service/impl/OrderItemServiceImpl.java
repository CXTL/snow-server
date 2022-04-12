package com.snow.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snow.order.entity.OrderItem;
import com.snow.order.mapper.OrderItemMapper;
import com.snow.order.service.OrderItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xt
 * @since 2022-04-12
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}
