package com.dupake.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 顺丰快递策略
 */
public class SfExpressStrategy extends AbstractExpressStrategy {
    private static final Logger LOG = LoggerFactory.getLogger(JdExpressStrategy.class);


    @Override
    public ExpressResVO doPrint(ExpressDTO expressDTO) {
        LOG.info("顺丰快递开始打印----");

        return new ExpressResVO();
    }

}
