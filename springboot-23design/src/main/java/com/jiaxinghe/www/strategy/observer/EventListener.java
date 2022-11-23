package com.jiaxinghe.www.strategy.observer;

import com.google.common.eventbus.Subscribe;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 3:05 PM
 */
public class EventListener {

    @Subscribe //加了订阅，这里标记这个方法是事件处理方法
    public void handle(NotifyEvent notifyEvent) {
        System.out.println("发送IM消息" + notifyEvent.getImNo());
        System.out.println("发送短信消息" + notifyEvent.getMobileNo());
        System.out.println("发送Email消息" + notifyEvent.getEmailNo());
    }
}
