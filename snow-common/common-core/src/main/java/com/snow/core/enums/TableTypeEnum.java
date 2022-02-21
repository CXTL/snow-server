package com.snow.core.enums;

import lombok.Getter;

import java.util.Locale;

/**
 * @Description 表类型枚举
 */
@Getter
public enum TableTypeEnum {

    TABLE("BASE TABLE",0),
    VIEW("VIEW",1),
    SQL("BASE TABLE",2),
    CODE("BASE TABLE",3 ),

    ;

    private final String value;

    private final Integer code;

    TableTypeEnum(String value, Integer code) {
        this.value = value;
        this.code = code;
    }


    /**
     * 枚举转换
     */
    public static TableTypeEnum transform(String value) {
        for (TableTypeEnum temp : TableTypeEnum.values()) {
            if (temp.getValue().equals(value)) {
                return temp;
            }
        }
        return null;
    }


}
