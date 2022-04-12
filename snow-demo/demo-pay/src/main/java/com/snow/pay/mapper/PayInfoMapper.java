package com.snow.pay.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.core.dto.demo.PayInfoDto;
import com.snow.pay.entity.PayInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayInfoMapper extends BaseMapper<PayInfo> {

    List<PayInfoDto> listPayInfoByPage();
}
