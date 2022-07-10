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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpressDTO {

    private String expressType;

    private String expressNo;

    private BigDecimal actualAmount;

    private String address;

    private String username;

    /**
     * 生产基地
     */
    private String productAddress;

}
