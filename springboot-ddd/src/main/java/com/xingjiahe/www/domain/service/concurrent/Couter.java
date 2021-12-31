package com.xingjiahe.www.domain.service.concurrent;

/**
 * <p></p>
 *没有锁的支持，volatile的修改不能依赖当前置 当前值可能在其他线程中被修改
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/25 下午1:39
 */
public class Couter {
    public volatile  static  int  count = 0;
    public static  void inc(){
        try {
            Thread.sleep(1);
        }catch (InterruptedException e){
        }
        count ++;
    }

    public static void main(String[] args) {
        for(int i=0; i<1000; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                   Couter.inc();
                }
            }).start();
        }
        System.out.println("运行结果:Couter.count="+Couter.count);
    }
}
