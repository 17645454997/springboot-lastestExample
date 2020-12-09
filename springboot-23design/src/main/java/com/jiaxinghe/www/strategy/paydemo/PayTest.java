package com.jiaxinghe.www.strategy.paydemo;

public class PayTest {
    public static void main(String[] args) {
        Order order =new Order("1","21343241269090009",324.45);
        System.out.println(order.pay(PayStrategy.ALI_PAY));
    }
}
