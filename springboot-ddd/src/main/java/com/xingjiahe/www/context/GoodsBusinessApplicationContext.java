package com.xingjiahe.www.context;


import com.sun.istack.internal.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/7/26 6:09 PM
 */
@Component
@EnableAsync
public class GoodsBusinessApplicationContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        GoodsBusinessApplicationContext.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return GoodsBusinessApplicationContext.applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String beanName, Class<T> clazz) {
        return GoodsBusinessApplicationContext.applicationContext.getBean(beanName, clazz);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        return GoodsBusinessApplicationContext.applicationContext.getBeansOfType(clazz);
    }

    public static Object getBeanByName(String clazzName) {
        return GoodsBusinessApplicationContext.applicationContext.getBean(clazzName);
    }

    /**
     * 使用时注意，如果需要异步处理event事件那就需要在事件处理时标注@Async
     *
     * @param event 系统事件
     */
    public static void publishEvent(ApplicationEvent event) {
        applicationContext.publishEvent(event);
    }
}