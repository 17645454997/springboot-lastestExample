package com.xingjiahe.www.threadpool;

import com.xingjiahe.www.infrastructure.util.LogUtils;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/1/20 下午3:22
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws Exception {
      final  ReentrantLock mainLock =  new ReentrantLock();
      mainLock.lock();
      try {
         ThreadPools.getInstance().submitHealthCheckTask(() -> getHealthCode(17645454997L)).get(5000, TimeUnit.MILLISECONDS);
      }catch (Exception e){
          //something
      }finally {
          mainLock.unlock();
      }
        ThreadPoolExecutor threadPoolExecutor   = new ThreadPoolExecutor(10,10,0L,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(10));
        threadPoolExecutor.execute(()->{
            System.out.println("Hi 线程池");
        });
        ExecutorService executor = new ThreadPoolExecutor(10,10,0L,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(10));
       try {
           executor.execute(ThreadPoolTest::printThread);
       }catch (Exception e){
           LogUtils.COMMON.warn("print  Thread  error:{}","");
       }finally {
           executor.shutdown();
       }

    }


    public static String getHealthCode(Long userNewId) {
        System.out.println("何佳兴的健康码是绿色");
        String message = "何佳兴的健康码是绿色" + "身份ID为:" + userNewId;
        return message;
    }

    public static void printThread() {
        for (int i = 0; i < 100; i++) {
           System.out.println(Thread.currentThread().getName());
        }
    }

}
