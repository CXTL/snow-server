package com.snow.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class SysDictItem  {

    @TableId(type= IdType.AUTO)
    private Long id;

    private String name;

    private String value;

    private String dictCode;

    private String sort;

    private Integer status;

    private Integer defaulted;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
