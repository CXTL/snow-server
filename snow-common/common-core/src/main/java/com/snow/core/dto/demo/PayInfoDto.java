package com.snow.core.dto.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayInfoDto {

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
