package com.jiaxinghe.www.strategy.demo;

public class CouponStrategy  implements PomotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("领取优惠卷，打车价格直线抵扣");
    }
}
