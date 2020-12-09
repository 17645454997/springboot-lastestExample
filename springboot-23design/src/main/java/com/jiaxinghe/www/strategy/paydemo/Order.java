package com.jiaxinghe.www.strategy.paydemo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private  String uid;
    private  String orderId;
    private  double amount;

    public PayState pay(String payKey) {
        Payment payment = PayStrategy.get(payKey);
        System.out.println("欢迎使用"+payment.getName());
        System.out.println("本次交易金额为 ："+amount +", 开始扣款。。。");
        return  payment.pay(uid,amount);
    }
}
