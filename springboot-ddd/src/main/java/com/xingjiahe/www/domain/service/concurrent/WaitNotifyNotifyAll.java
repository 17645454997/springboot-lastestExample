package com.xingjiahe.www.domain.service.concurrent;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/25 下午2:03
 */
public class WaitNotifyNotifyAll {
    int index;
    public synchronized String pop() throws  Exception{
        this.notifyAll();
        while (index == -1){
            this.wait();
        }
        String [] buffer = new String[5];
        String good = buffer[index];
        buffer[index] = null;
        index --;
        return  good;
    }
}
