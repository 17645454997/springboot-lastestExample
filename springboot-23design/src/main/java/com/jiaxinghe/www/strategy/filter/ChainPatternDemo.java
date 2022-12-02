package com.jiaxinghe.www.strategy.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 11:40 AM
 */
@Component("ChainPatternDemo")
public class ChainPatternDemo {

    @Autowired
    private List<AbstractHandler> abstractHandleList;

    /**
     * spring 注入会后自动执行 ，责任链对象连接起来
     */
    @PostConstruct
    public  void initializeChainFilter(){
        exec(new Request(),new Response());
    }

    public  Response exec(Request request, Response response){
        abstractHandleList.forEach(abstractHandler -> abstractHandler.doFilter(request,response));
        return  response;
    }
}
