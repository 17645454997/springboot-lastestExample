package com.jiaxinghe.www.bjsxt.strategy.demo;

public class EmptyStrategy implements PomotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
