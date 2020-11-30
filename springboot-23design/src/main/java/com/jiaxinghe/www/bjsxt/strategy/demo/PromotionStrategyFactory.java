package com.jiaxinghe.www.bjsxt.strategy.demo;

import java.util.HashMap;
import java.util.Map;

public class PromotionStrategyFactory {
    private static Map<String, PomotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<String,
            PomotionStrategy>();

    static {
        PROMOTION_STRATEGY_MAP.put(PomotionKey.COUPON, new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PomotionKey.CASHBACK, new CashbackStrategy());
        PROMOTION_STRATEGY_MAP.put(PomotionKey.GROUPBUY, new GroupbuyStrategy());
    }

    private  static final  PomotionStrategy NON_PROMOTION = new EmptyStrategy();
    private interface PomotionKey {
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBUY = "GROUPBUY";
    }

    public  static  PomotionStrategy getPomotionStrategy (String pomotionKey){
        PomotionStrategy pomotionStrategy = PROMOTION_STRATEGY_MAP.get(pomotionKey);
        return  pomotionStrategy == null ? NON_PROMOTION : pomotionStrategy;
    }
}
