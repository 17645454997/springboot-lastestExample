package com.xingjiahe.www.lock;

import java.util.Objects;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/10/26 4:58 PM
 */
public class DeadLock implements Runnable{

    static Object chopsticks = new Object();
    static  Object spoon = new Object();
    private  boolean flag;

    public  DeadLock(boolean flag){
        this.flag = flag;
    }
    @Override
    public void run() {
       if(flag){
           while(true){
               synchronized (chopsticks){
                   System.out.println(Thread.currentThread().getName() + "if ----- chopstick");
                   synchronized (spoon){
                       System.out.println(Thread.currentThread().getName()+ " if ------ spoon");
                   }
               }
           }
       }else{
           while(true){
               synchronized (spoon){
                   System.out.println(Thread.currentThread().getName() + "else -- spoon");
                   synchronized (chopsticks){
                       System.out.println(Thread.currentThread().getName() + "else -- chopsticks");
                   }
               }
           }
       }
    }
}
