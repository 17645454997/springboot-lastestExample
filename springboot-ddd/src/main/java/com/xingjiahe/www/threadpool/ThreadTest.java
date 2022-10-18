package com.xingjiahe.www.threadpool;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/10/18 11:24 AM
 */
public class ThreadTest extends  Thread{

    @Override
    public void run() {
         System.out.println(currentThread().getName());
    }

    public static void main(String args[]) {
    	Thread t1 = new ThreadTest();
        t1.start();
    	}
}
