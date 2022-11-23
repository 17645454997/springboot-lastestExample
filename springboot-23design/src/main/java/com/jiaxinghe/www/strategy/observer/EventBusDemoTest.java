package com.jiaxinghe.www.strategy.observer;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 3:06 PM
 */
public class EventBusDemoTest {
    public static void main(String[] args) {

        EventListener eventListener = new EventListener();
        EventBusCenter.register(eventListener);
        EventBusCenter.post(new NotifyEvent("13372817283", "123@qq.com", "666"));
    }
}
