package com.xingjiahe.www.domain.service.concurrent;

/**
 * <p></p>
 *当锁被释放，共享变量会写入主存，当获得锁以后，cpu缓存中的内容被置为无效
 * 编译器在处理synchronized 方法和代码块，不会将synchronized 方法活代码块之外，从而避免了代码重排的问题
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/25 下午1:52
 */
public class SynchroziedIdGentrator {
    private  int value = 0;
    public synchronized int getNext(){
        return value++;
    }
    public  int getNextV2(){
        synchronized (this){
            return  value++;
        }
    }
}
