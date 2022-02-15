package com.xingjiahe.www.threadpool;

import java.util.concurrent.TimeUnit;
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


    }


    public static String getHealthCode(Long userNewId) {
        System.out.println("何佳兴的健康码是绿色");
        String message = "何佳兴的健康码是绿色" + "身份ID为:" + userNewId;
        return message;
    }
}
