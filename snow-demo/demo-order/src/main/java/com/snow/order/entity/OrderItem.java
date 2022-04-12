package com.snow.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xt
 * @since 2022-04-12
 */
@TableName("demo_order_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem extends Model<OrderItem> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单子表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Long orderNo;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品图片地址
     */
    private String productImage;

    /**
     * 生成订单时的商品单价，单位是元,保留两位小数
     */
    private BigDecimal currentUnitPrice;

    /**
     * 商品数量
     */
    private Integer quantity;

    /**
     * 商品总价,单位是元,保留两位小数
     */
    private BigDecimal totalPrice;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
