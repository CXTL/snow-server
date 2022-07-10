package com.dupake.demo;

/**
 * 策略模式 - 服务方
 */
public interface PrintService {

    ExpressResVO doPrint(ExpressDTO expressDTO);

    ExpressStrategy getExpressStrategy();

    void setExpressStrategy(ExpressStrategy expressStrategy);
}
