package com.jiaxinghe.www.strategy.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 11:38 AM
 */
@Component
@Order(1)
public class CheckBlackFilterObject extends  AbstractHandler{

    @Override
    public void doFilter(Request request, Response response) {
        System.out.println("校验黑名单1");
    }
}
