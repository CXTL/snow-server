package com.snow.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author haoxr
 * @date 2020-11-06
 */
@Data
public class SysMenu {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long parentId;

    private String name;

    private String icon;

    /**
     * 路由路径
     */
    private String path;

    private String component;

    private Integer sort;

    private Integer visible;

    private String redirect;


    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
