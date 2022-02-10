package com.snow.meta.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MetaFieldInfo {

    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     *数据表ID
     */
    private Long tableId;
    /**
     *字段名称
     */
    private String fieldName;
    /**
     *字段中文名称
     */
    private String fieldNameChinese;
    /**
     *字段类型
     */
    private String type;
    /**
     *字段长度
     */
    private String fieldLength;
    /**
     *小数点位数
     */
    private String fieldDecimal;
    /**
     *逻辑删除标识：0-未删除；1-已删除
     */
    private Integer deleted;
    /**
     *创建时间
     */
    private LocalDateTime createTime;
    /**
     *更新时间
     */
    private LocalDateTime updateTime;
    /**
     *备注
     */
    private String description;

}