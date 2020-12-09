package com.jiaxinghe.www.strategy.demo;

public class CashbackStrategy implements PomotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("返现促销，返回指定车费到支付宝号");
    }
}
