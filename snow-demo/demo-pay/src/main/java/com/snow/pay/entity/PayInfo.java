package com.snow.pay.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@TableName("demo_pay_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayInfo extends Model<PayInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 订单号
     */
    private Long orderNo;

    /**
     * 支付平台:1-支付宝,2-微信
     */
    private Integer payPlatform;

    /**
     * 支付流水号
     */
    private String platformNumber;

    /**
     * 支付状态
     */
    private String platformStatus;

    /**
     * 支付金额
     */
    private BigDecimal payAmount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
