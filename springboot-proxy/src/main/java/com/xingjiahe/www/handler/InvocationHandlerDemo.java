package com.xingjiahe.www.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/10/27 2:43 PM
 */
public class InvocationHandlerDemo implements InvocationHandler {
    //目标对象
     private  Object  target;

     public  InvocationHandlerDemo(Object target){
         super();
         this.target =target;
     }

    @Override
    public  Object invoke(Object proxy , Method method ,Object[] args) throws Throwable{
         System.out.println("-----------");
         Object result =  method.invoke(target,args);
         System.out.println("-----------");
         return  result;
    }

    public  Object  getProxy(){
         return  Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),target.getClass().getInterfaces(),this);
    }

}
