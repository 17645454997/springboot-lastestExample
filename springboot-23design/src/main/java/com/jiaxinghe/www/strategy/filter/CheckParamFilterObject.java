package com.jiaxinghe.www.strategy.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 11:35 AM
 */
@Component
@Order(1)
public class CheckParamFilterObject  extends  AbstractHandler {

    @Override
    public void doFilter(Request request, Response response) {
        System.out.println("非空检查2");
    }
}
