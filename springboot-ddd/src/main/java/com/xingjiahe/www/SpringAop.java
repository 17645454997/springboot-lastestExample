package com.xingjiahe.www;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect//注册切面
@Configuration//注册配置类
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.xingjiahe.www")//注册扫描包
public class SpringAop {

    @Pointcut("execution(* com.xingjiahe.www.*.*(..))")
    public void pj(){}

    @Before("pj()")
    public void sayHi(){
        System.out.println("2");
    }

    @After("pj()")
    public void sayHello(){
        System.out.println("5");
    }
    @AfterReturning("pj()")
    public void sayGood(){
        System.out.println("6");
    }
    @AfterThrowing("pj()")
    public void sayNo(){
        System.out.println("6");
    }

    @Around("pj()")
    //这里需要注意，返回的参数类型要与被加强方法的参数一致，否则会报错
    public int process(ProceedingJoinPoint joinPoint){
        System.out.println("1");
        int obj=0;
        try{
            obj  = (Integer)joinPoint.proceed();
            System.out.println("4");
        }catch (Throwable e){
            return 7;
        }
        return obj;
    }
}
