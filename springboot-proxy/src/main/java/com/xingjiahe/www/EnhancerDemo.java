package com.xingjiahe.www;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class EnhancerDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerDemo.class);
        enhancer.setCallback(new MethodIntercetorImpl());
        EnhancerDemo demo = (EnhancerDemo)enhancer.create();
        demo.test();
        System.out.println(demo);
    }
   public void test(){
        System.out.println("EnhancerDemo test()");
   }

    private  static  class  MethodIntercetorImpl implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.out.println("before");
            Object result = methodProxy.invokeSuper(o, args);
             System.out.println("after");
            return result;
        }

    }
}
