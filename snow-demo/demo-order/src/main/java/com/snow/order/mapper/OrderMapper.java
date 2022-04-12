package com.snow.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.core.dto.demo.OrderDto;
import com.snow.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xt
 * @since 2022-04-12
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    List<OrderDto> listOrderByPage();
}
