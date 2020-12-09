package com.jiaxinghe.www.strategy.paydemo;

public class WecatPay  extends Payment {
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 256;
    }
}
