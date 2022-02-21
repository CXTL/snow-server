package com.snow.core.enums;

import lombok.Getter;

/**
 * @Description 是否类型枚举
 */
@Getter
public enum YesNoEnum {

    NO(0,"未"),
    YES(1,"已"),

    ;

    private final Integer value;

    private final String description;

    YesNoEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }


    /**
     * 枚举转换
     */
    public static YesNoEnum transform(Integer value) {
        for (YesNoEnum temp : YesNoEnum.values()) {
            if (temp.getValue().equals(value)) {
                return temp;
            }
        }
        return null;
    }


}
