package com.xingjiahe.www.template;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/2/14 下午7:32
 */
public class PrintTest {
   static  int flag = 0;
   static PrintTest t = new PrintTest();
    public static void main(String[] args) {
        Thread myThread = new Thread(new myThread1(t));
        Thread myThread2 = new Thread(new myThread2(t));
        myThread.start();
        myThread2.start();
    }
    public static class  myThread1 implements  Runnable{
   public PrintTest t;
   public myThread1 (PrintTest t){
       this.t =t;
   }
        @Override
        public void run() {
            int i=0;
            while (i<=1000) {
                synchronized (t) {
                    if (flag == 0) {
                        System.out.println(Thread.currentThread().getName() + "=" + i);
                        i += 2;
                        flag = 1;
                    }
                }
            }
        }
    }
    public static  class  myThread2 implements  Runnable{
        public PrintTest t;
        public myThread2 (PrintTest t){
            this.t =t;
        }
        @Override
        public void run() {
            int i=1;
            while (i<=1000) {
                synchronized (t) {

                    if (flag == 1) {
                        System.out.println(Thread.currentThread().getName() + "=" + i);
                        i += 2;
                        flag = 0;
                    }
                }
            }
        }
    }
}
