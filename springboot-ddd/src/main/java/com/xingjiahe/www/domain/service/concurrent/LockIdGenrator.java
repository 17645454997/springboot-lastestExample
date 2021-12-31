package com.xingjiahe.www.domain.service.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/25 下午8:43
 */
public class LockIdGenrator {
    private  ReentrantLock lock = new ReentrantLock();
    private  int value = 0;
    public  int getNext(){
        lock.lock();
        try {
            return  value++;
        }finally {
            lock.unlock();
        }
    }

}
