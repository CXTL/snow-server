package com.dupake.demo;

import java.util.Objects;

import static com.dupake.demo.ExpressTypeEnum.*;

/**
 * 快递服务实现类
 */
public class ExpressServiceImpl implements ExpressService {

    @Override
    public ExpressResVO expressPrint(ExpressReqVO expressReqVO) {
        PrintService printService = new PrintServiceImpl();
        ExpressStrategy expressStrategy = null;
        String expressType = expressReqVO.getExpressType();
        ExpressTypeEnum expressTypeEnum = getExpressType(expressType);
        switch (Objects.requireNonNull(expressTypeEnum)) {
            case SF:
                expressStrategy = new SfExpressStrategy();
                break;
            case JD:
                expressStrategy = new JdExpressStrategy();
                break;
            default:
                expressStrategy = new SfExpressStrategy();
                break;
        }
        printService.setExpressStrategy(expressStrategy);
        ExpressResVO expressResVO = printService.doPrint(new ExpressDTO());
        return expressResVO;
    }
}
