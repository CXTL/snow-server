package com.snow.pay.service;

import com.snow.core.dto.demo.PayInfoDto;
import com.snow.core.dto.demo.PayInfoParam;

import java.util.List;

public interface PayInfoService {

    PayInfoDto findPayInfoById(Integer payInfoId);

    Integer add(PayInfoParam payInfoParam);

    Integer update(PayInfoParam payInfoParam);

    Integer delete(Long PayInfoId);

    List<PayInfoDto> listPayInfo();

    List<PayInfoDto> pageListPayInfo(Integer pageSize, Integer pageNum);

}
