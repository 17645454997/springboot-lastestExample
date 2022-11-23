package com.jiaxinghe.www.strategy.observer;

import com.google.common.annotations.Beta;
import com.google.common.eventbus.EventBus;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 2:58 PM
 */
public class EventBusCenter {

    private  static EventBus eventBus  = new EventBus();

    private  EventBusCenter () {

    }
    @Beta
    public  static  EventBus getInstance() {
        return  eventBus;
    }

    /**
     * 添加观察者
     */
    @Beta
    public  static  void  register(Object obj){
        eventBus.register(obj);
    }

    /**
     * 移除观察者
     */
    @Beta
    public  static  void  unregister(Object obj){
        eventBus.unregister(obj);
    }

    /**
     * 推送消息给观察者
     */
    @Beta
    public  static  void  post(Object obj){
        eventBus.post(obj);
    }

}

