package com.snow.pay.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.snow.core.dto.demo.PayInfoDto;
import com.snow.core.dto.demo.PayInfoParam;
import com.snow.core.exception.Asserts;
import com.snow.pay.entity.PayInfo;
import com.snow.pay.mapper.PayInfoMapper;
import com.snow.pay.service.PayInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PayInfoServiceImpl implements PayInfoService {

    @Autowired
    private PayInfoMapper payInfoMapper;


    /**
     * 新增支付
     *
     * @param payInfoParam
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer add(PayInfoParam payInfoParam) {
        PayInfo payInfo = PayInfo.builder().build();
        BeanUtils.copyProperties(payInfoParam, payInfo);
        checkPayNumberUnique(payInfo);
        payInfo.setCreateTime(LocalDateTime.now());
        payInfo.setUpdateTime(payInfo.getCreateTime());
        return payInfoMapper.insert(payInfo);
    }

    /**
     * 修改支付
     *
     * @param payInfoParam
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer update(PayInfoParam payInfoParam) {
        getPayInfoById(payInfoParam.getId());
        PayInfo payInfo = PayInfo.builder().build();
        BeanUtils.copyProperties(payInfoParam, payInfo);
        checkPayNumberUnique(payInfo);
        payInfo.setUpdateTime(LocalDateTime.now());
        return payInfoMapper.updateById(payInfo);
    }


    /**
     * 删除支付
     *
     * @param PayInfoId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer delete(Long PayInfoId) {
        return payInfoMapper.deleteById(PayInfoId);
    }

    /**
     * 根据ID查询支付信息
     *
     * @param payInfoId
     * @return
     */
    @Override
    public PayInfoDto findPayInfoById(Integer payInfoId) {
        PayInfo payInfo = getPayInfoById(payInfoId);
        PayInfoDto payInfoDto = PayInfoDto.builder().build();
        BeanUtils.copyProperties(payInfo, payInfoDto);
        return payInfoDto;
    }

    /**
     * 支付信息列表
     *
     * @return
     */
    @Override
    public List<PayInfoDto> listPayInfo() {
        List<PayInfo> payInfos = payInfoMapper.selectList(new LambdaQueryWrapper<>());
        return payInfos.stream().map(a -> {
            PayInfoDto payInfoDto = PayInfoDto.builder().build();
            BeanUtils.copyProperties(a, payInfoDto);
            return payInfoDto;
        }).collect(Collectors.toList());
    }

    /**
     * 分页查询支付信息
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public List<PayInfoDto> pageListPayInfo(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return payInfoMapper.listPayInfoByPage();
    }

    /**
     * 检查支付流水号重复
     *
     * @param payInfoInfo
     */
    private void checkPayNumberUnique(PayInfo payInfoInfo) {
        PayInfo payInfo = payInfoMapper.selectOne(
                new LambdaQueryWrapper<PayInfo>()
                        .eq(PayInfo::getPlatformNumber, payInfoInfo.getPlatformNumber()));
        if (Objects.nonNull(payInfo)) {
            Asserts.fail("支付流水号重复");
        }
    }

    /**
     * 获取支付信息
     *
     * @param payInfoId
     * @return
     */
    private PayInfo getPayInfoById(Integer payInfoId) {
        PayInfo payInfo = payInfoMapper.selectById(payInfoId);
        if (Objects.isNull(payInfo)) {
            Asserts.fail("支付信息不存在");
        }
        return payInfo;
    }


}
