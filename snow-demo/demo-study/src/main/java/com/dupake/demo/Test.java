package com.dupake.demo;

public class Test {

    public static void main(String[] args) {
        ExpressService expressService = new ExpressServiceImpl();
        ExpressReqVO expressReqVO = ExpressReqVO.builder()
                .expressType(ExpressTypeEnum.SF.getCode()).build();
        expressService.expressPrint(expressReqVO);
    }
}
