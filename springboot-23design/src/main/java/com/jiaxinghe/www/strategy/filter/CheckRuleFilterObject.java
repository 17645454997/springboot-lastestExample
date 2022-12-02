package com.jiaxinghe.www.strategy.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 11:39 AM
 */
@Component
@Order(1)
public class CheckRuleFilterObject extends  AbstractHandler{

    @Override
     public  void doFilter(Request request, Response response) {
        System.out.println("check rule3");
    }
}
