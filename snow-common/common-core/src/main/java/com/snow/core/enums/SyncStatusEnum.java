package com.snow.core.enums;

/**
 */
public enum SyncStatusEnum {

    //同步状态，1 未同步 2 同步中 3 同步成功 4 同步失败
    SYNC_NO(1, "未同步"),

    SYNC_ING(2, "同步中"),

    SYNC_SUCCESS(3, "同步成功"),

    SYNC_FALSE(4, "同步失败");

    private Integer status;

    private String desc;

    SyncStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 枚举转换
     */
    public static SyncStatusEnum transform(String status) {
        for (SyncStatusEnum temp : SyncStatusEnum.values()) {
            if (temp.getStatus().equals(status)) {
                return temp;
            }
        }
        return null;
    }
}
