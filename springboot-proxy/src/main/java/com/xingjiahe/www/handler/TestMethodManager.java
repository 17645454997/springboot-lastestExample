package com.xingjiahe.www.handler;

import com.google.common.collect.Maps;
import com.xingjiahe.www.enms.EnumTestMethodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


import java.util.Map;

@Component
public class TestMethodManager implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ApplicationContext applicationContext;
    private static Map<EnumTestMethodType, TestMethodHandler> testMethodHandlerMap = Maps.newConcurrentMap();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Map<String, TestMethodHandler> handlerMap = applicationContext.getBeansOfType(TestMethodHandler.class);
        handlerMap.forEach((k, v) -> {
            TestMethodHandler testMethodHandler = applicationContext.getBean(k, TestMethodHandler.class);
            testMethodHandlerMap.put(testMethodHandler.getMethod(),testMethodHandler);
        });

    }
    public static  TestMethodHandler getHandler(EnumTestMethodType type){
        if(type==null){
            return null;
        }
        return  testMethodHandlerMap.get(type);
    }

}
