package com.dupake.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 工厂基地类型类型枚举
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum AddressTypeEnum {

    ZH("0001", "珠海"),
    JSLS("0002", "江苏涟水"),
    XJ("0003", "先进二场"),

    ;

    private String code;

    private String desc;



}
