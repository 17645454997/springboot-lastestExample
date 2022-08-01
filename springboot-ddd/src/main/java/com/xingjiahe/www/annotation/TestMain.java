package com.xingjiahe.www.annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/7/7 7:36 PM
 */
public class TestMain {

    @Test
    public void  TestMain(){
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        System.out.println("userService" + userService);
    }
}
