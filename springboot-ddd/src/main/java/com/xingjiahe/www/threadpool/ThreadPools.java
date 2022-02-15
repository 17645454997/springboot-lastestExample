package com.xingjiahe.www.threadpool;

import java.util.concurrent.*;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/1/19 下午2:17
 */
public class ThreadPools {

    private static final RejectedExecutionHandler ABORT = new ThreadPoolExecutor.AbortPolicy();

    private static final RejectedExecutionHandler CALLER_RUN = new ThreadPoolExecutor.CallerRunsPolicy();

    private static final RejectedExecutionHandler DISCARD = new ThreadPoolExecutor.DiscardPolicy();

    private static class ThreadPoolManagerHolder {
        public static ThreadPools instance = new ThreadPools();
    }

    private final ExecutorService hitchPool;

    private ThreadPools() {
        hitchPool = newThreadPool(2, 16, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2048), new HitchWorkFactory(""), CALLER_RUN);
    }

    private ExecutorService newThreadPool(int corePoolSize,
                                          int maximumPoolSize,
                                          long keepAliveTime,
                                          TimeUnit unit,
                                          ArrayBlockingQueue<Runnable> workQueue,
                                          ThreadFactory threadFactory,
                                          RejectedExecutionHandler abort) {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, abort);
    }
    public static ThreadPools getInstance() {
        return ThreadPoolManagerHolder.instance;
    }

    public <T> Future<T> submitHealthCheckTask(Callable<T> task) {
        try {
            Future<T> submit = hitchPool.submit(task);
            hitchPool.shutdown();
             return submit;
        } catch (Exception e) {
            //log
        }
        return null;
    }


    public void submitLoggerTask(Runnable task) {
        try {
            hitchPool.submit(task);
            hitchPool.execute(task);
        } catch (Exception e) {
            //log
        }
    }

}
