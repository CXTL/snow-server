package com.dupake.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 京东快递策略
 */
public class JdExpressStrategy extends AbstractExpressStrategy {

    private static final Logger LOG = LoggerFactory.getLogger(JdExpressStrategy.class);

    @Override
    public ExpressResVO doPrint(ExpressDTO expressDTO) {
        LOG.info("京东快递开始打印----");

        return new ExpressResVO();
    }
}
