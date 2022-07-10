package com.dupake.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 打印快递请求信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpressReqVO {

    private String expressType;

    private String expressNo;

    private BigDecimal actualAmount;

    private String address;

    private String username;

}
