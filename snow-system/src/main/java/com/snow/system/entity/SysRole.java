package com.snow.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SysRole  {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String code;

    private Integer sort;

    private Integer status;

    @TableLogic(value = "0", delval = "1")
    private Integer deleted;


    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
