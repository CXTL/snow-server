package com.dupake.demo;

/**
 * 策略模式 - 客户方
 * 快递服务
 */
public interface ExpressService {

    /**
     * 打印快递信息
     *
     * @param expressReqVO
     * @return
     */
    ExpressResVO expressPrint(ExpressReqVO expressReqVO);

}
