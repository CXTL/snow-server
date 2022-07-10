package com.dupake.demo;

/**
 * 快递策略
 */
public interface ExpressStrategy {

    /**
     * 快递打印
     *
     * @param expressDTO
     * @return
     */
    ExpressResVO expressPrint(ExpressDTO expressDTO);

}
