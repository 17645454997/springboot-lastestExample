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

    private  AbstractHandler abstractHandler;

    /**
     * spring 注入会后自动执行 ，责任链对象连接起来
     */
    @PostConstruct
    public  void initializeChainFilter(){
        for(int i = 0; i<abstractHandleList.size();i++){
            if(i == 0){
                abstractHandler = abstractHandleList.get(0);
            }else{
                AbstractHandler currentHandler  = abstractHandleList.get(i-1);
                AbstractHandler nextHandler = abstractHandleList.get(i);
                currentHandler.setNextHandler(nextHandler);
            }
        }
        exec(new Request(),new Response());
    }

    public  Response exec(Request request, Response response){
        abstractHandler.filter(request, response);
        return  response;
    }


    public AbstractHandler getAbstractHandler() {
        return abstractHandler;
    }

    public void setAbstractHandler(AbstractHandler abstractHandler) {
        this.abstractHandler = abstractHandler;
    }
}
