package com.xingjiahe.www;


import org.springframework.stereotype.Component;

@Component
public class Girl implements  Student{//实现了接口，java会用JDK动态代理，可以设置成cglib的方式来处理
    @Override
    public int dance(){
        System.out.println("3");
     //   int i=1/0;//这里注释掉就是正常返回
        return 7;
    }
}

interface Student {
    int dance();
}

