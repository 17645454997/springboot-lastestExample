package com.xingjiahe.www.domain.service.concurrent;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/25 下午1:30
 */
public class Worker {
    private volatile  boolean done;
    public void setDone(boolean done){
        this.done =done;
    }
    public void work(){
        while (!done){
            //执行任务
        }
    }
}
