package com.dupake.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.PublicKey;

/**
 * 快递类型枚举
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExpressTypeEnum {

    SF("0001", "顺丰"),
    JD("0002", "京东"),
    YD("0003", "韵达"),
    ST("0004", "申通"),
    ZT("0005", "中通"),
    YT("0006", "圆通"),

    ;

    private String code;

    private String desc;

    public static ExpressTypeEnum getExpressType(String code){
        for (ExpressTypeEnum typeEnum : ExpressTypeEnum.values()) {
            if(typeEnum.code.equals(code)){
                return typeEnum;
            }
        }
        return null;
    }

}
