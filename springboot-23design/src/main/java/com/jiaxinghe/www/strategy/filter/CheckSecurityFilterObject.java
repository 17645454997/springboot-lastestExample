package com.jiaxinghe.www.strategy.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 11:37 AM
 */
@Component
@Order(2)
public class CheckSecurityFilterObject extends  AbstractHandler{

    @Override
   public void doFilter(Request request, Response response) {
        System.out.println("安全调用校验");
    }

}
