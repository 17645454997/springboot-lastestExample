package com.xingjiahe.www.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/10/18 11:34 AM
 */
public class ThreadCallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "子线程名称为" + Thread.currentThread().getName();
    }

    public static void main(String args[]) throws Exception {
        ThreadCallableTest callableTest = new ThreadCallableTest();
        FutureTask<String> futureTask = new FutureTask<>(callableTest);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
