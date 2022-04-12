package com.snow.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.order.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xt
 * @since 2022-04-12
 */
@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {

}
