package com.xingjiahe.www.lock;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/8/2 11:39 AM
 */
public class LOCK_ABC_SYNCHRONIZED {

    private int num;
    private  static  final  Object Lock = new Object();

    private void printABC(int targetNum) {
       synchronized (Lock) {
           for (int i = 0; i < 100; ) {
               while (num % 3 != targetNum) {
                    try{
                         Lock.wait();
                    }catch(Exception e){
                  e.printStackTrace();
                    }
               }
               num++;
               i++;
               System.out.print(Thread.currentThread().getName());
               Lock.notifyAll();
           }
       }
    }

    public static void main(String args[]) {
        LOCK_ABC_SYNCHRONIZED lockABC = new LOCK_ABC_SYNCHRONIZED();
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
}
