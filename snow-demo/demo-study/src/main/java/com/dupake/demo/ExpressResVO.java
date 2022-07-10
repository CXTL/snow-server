package com.dupake.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 打印快递结果信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpressResVO {

    private String expressName;

    private String expressNo;

    private BigDecimal actualAmount;

    private String address;

    private String username;

}
