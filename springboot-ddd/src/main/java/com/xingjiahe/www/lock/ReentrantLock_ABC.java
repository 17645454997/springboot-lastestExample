package com.xingjiahe.www.lock;

import com.xingjiahe.www.infrastructure.util.LogUtils;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/8/2 2:21 PM
 */
public class ReentrantLock_ABC {
    private static int num;
    private static Lock lock = new ReentrantLock(false);
    private static final RejectedExecutionHandler ABORT = new ThreadPoolExecutor.AbortPolicy();
    static ExecutorService executorPool = new ThreadPoolExecutor(10, 10, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<>(100), ABORT);

    private static void printABC(int targetNum) {
        for (int i = 0; i < 100; ) {
            lock.lock();
            if (num % 3 == targetNum) {
                num++;
                i++;
                System.out.print(Thread.currentThread().getName());
            }
            lock.unlock();
        }

    }

    public static void main(String args[]) {
        ReentrantLock_ABC lockABC = new ReentrantLock_ABC();
        new Thread(() -> {
            lockABC.printABC(0);
        }, "A").start();
        new Thread(() -> {
            lockABC.printABC(1);
        }, "B").start();
        new Thread(() -> {
            lockABC.printABC(2);
        }, "C").start();
    }

    public static void submitPrintTask(Runnable task) {
        try {
            executorPool.submit(task);
        } catch (Exception e) {
            LogUtils.COMMON.error("submitPrintTask error", e);
        }

    }
}
