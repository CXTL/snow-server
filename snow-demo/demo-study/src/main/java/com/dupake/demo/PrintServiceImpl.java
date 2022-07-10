package com.dupake.demo;

public class PrintServiceImpl implements PrintService{

    private ExpressStrategy expressStrategy;

    @Override
    public ExpressResVO doPrint(ExpressDTO expressDTO) {
        return expressStrategy.expressPrint(expressDTO);
    }

    @Override
    public ExpressStrategy getExpressStrategy() {
        return expressStrategy;
    }

    @Override
    public void setExpressStrategy(ExpressStrategy expressStrategy) {
        this.expressStrategy = expressStrategy;
    }
}
