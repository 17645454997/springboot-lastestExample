package com.xingjiahe.www;

import com.xingjiahe.www.handler.MyInvocationHandler;
import com.xingjiahe.www.iface.UserService;
import com.xingjiahe.www.iface.impl.UserServiceImpl;
import org.junit.Test;

public class ProxyTest {

    @Test
    public  void testProxy()throws Throwable {
        UserService userService = new UserServiceImpl();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
        UserService proxy = (UserService) invocationHandler.getProxy();
        proxy.add();
    }
}
