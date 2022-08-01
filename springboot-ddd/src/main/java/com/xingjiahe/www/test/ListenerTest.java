package com.xingjiahe.www.test;

import com.xingjiahe.www.SpringbootDddApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/7/26 5:09 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootDddApplication.class})
public class ListenerTest implements ApplicationContextAware {
    private static ApplicationContext applicationContext;


    @Test
    public void test(){
        EmailEvent   emailEvent  = new EmailEvent("hello", "boylmx@163.com", "this is a email text!");
        applicationContext.publishEvent(emailEvent);

//        doHandler(emailEvent);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ListenerTest.applicationContext =applicationContext;
    }


}
