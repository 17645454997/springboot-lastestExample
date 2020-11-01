//package com.xingjiahe.www.infrastructure.util;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.BeanFactoryAware;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.beans.factory.support.BeanDefinitionBuilder;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.stereotype.Component;
//
///**
// * @author chenlong
// * @date 2020-06-11 17:56
// * @since 1.0-SNAPSHOT
// */
//@Component
//public class BeanUtils extends org.springframework.beans.BeanUtils implements BeanFactoryAware {
//
//    private static ConfigurableBeanFactory beanFactory;
//
//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        com.hellobike.infrastructure.util.BeanUtils.beanFactory = (ConfigurableBeanFactory) beanFactory;
//    }
//
//    public static void registerListenerBean(Class<?> clazz) {
//        BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(clazz).getBeanDefinition();
//        ((BeanDefinitionRegistry) beanFactory).registerBeanDefinition(clazz.getCanonicalName(), beanDefinition);
//    }
//
//    public static <T> T getBean(Class<T> clazz) {
//        return beanFactory.getBean(clazz);
//    }
//
//    public static <T> T getBean(Class<T> clazz, Object... args) {
//        return beanFactory.getBean(clazz, args);
//    }
//
//    public static <T> T getBean(String name, Class<T> clazz) throws BeansException {
//        return beanFactory.getBean(name, clazz);
//    }
//
//}
