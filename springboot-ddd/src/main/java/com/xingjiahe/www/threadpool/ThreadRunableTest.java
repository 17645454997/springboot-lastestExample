package com.xingjiahe.www.threadpool;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/10/18 11:27 AM
 */
public class ThreadRunableTest implements Runnable{

    @Override
    public void run() {
        System.out.println("1111111");
    }
    public static void main(String args[]) {
        ThreadRunableTest threadRunableTest = new ThreadRunableTest();
        new Thread(threadRunableTest).start();
    	}
}
