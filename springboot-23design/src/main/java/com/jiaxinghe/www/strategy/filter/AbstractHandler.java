package com.jiaxinghe.www.strategy.filter;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 11:28 AM
 */
public abstract class AbstractHandler {

    /**
     * 责任链中下一个对象
     */
    private  AbstractHandler nextHandler;


    public  void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public  void filter (Request request , Response response) {
        doFilter(request,response);
        if(getNextHandler() != null){
            getNextHandler().filter(request, response);
        }
    }


    public  AbstractHandler getNextHandler() {
        return  nextHandler;
    }


    /**
     * 具体方法交给子类实现
     * @param request
     * @param response
     */
    abstract void doFilter(Request request, Response response);
}
