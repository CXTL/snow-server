package com.dupake.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class AbstractExpressStrategy implements ExpressStrategy {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractExpressStrategy.class);
    /**
     * 具体执行打印方法逻辑
     *
     * @param expressDTO
     * @return
     */
    public ExpressResVO doPrint(ExpressDTO expressDTO) {
        return new ExpressResVO();
    }

    /**
     * --获取测试数据使用--模拟快递数据
     *
     * @return
     */
    private ExpressDTO getExpressInfo() {
        LOG.info("获取快递打印单数据---");
        return ExpressDTO
                .builder()
                .expressNo("SF123456")
                .expressType(ExpressTypeEnum.SF.getCode())
                .actualAmount(new BigDecimal(100))
                .address("深圳")
                .username("张三")
                .productAddress(AddressTypeEnum.ZH.getCode())
                .build();
    }


    /**
     * 快递打印模板方法
     *
     * @param expressDTO
     * @return
     */
    @Override
    public final ExpressResVO expressPrint(ExpressDTO expressDTO) {
        //获取快递打印信息
        ExpressDTO expressInfo = getExpressInfo();
        //组装快递打印数据
        ExpressResVO expressResVO = doPrint(expressInfo);
        return expressResVO;
    }
}
