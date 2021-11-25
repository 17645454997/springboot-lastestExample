package com.xingjiahe.www;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Method;

@RunWith(SpringJUnit4ClassRunner.class)//junit整合spring
@ContextConfiguration(classes={SpringAop.class})//标出配置类，如果是配置文件，使用locations参数

public class TestAop {

    @Autowired
   // private Girl girl;
     Student girl;//如果是jdk动态代理，这里必须是接口类型，如果用上面的注入方式，会报错

    @Test
    public void Test() throws Exception {
        Class calzz = Class.forName("com.xingjiahe.www.Girl");
        Object obj = calzz.newInstance();
        Method method = calzz.getMethod("dance");
        //method.invoke(obj);
       //  Student student = (Student) AopContext.currentProxy();
        girl.dance();
   //     girl = new Girl();
     //   girl.dance();
       // System.out.println(girl.dance());
//        System.out.println(ans);
    }
}


