package com.jiaxinghe.www.strategy.demo;

public class GroupbuyStrategy implements PomotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("拼团 ，满20 人成团，全团享受团购价");
    }
}
