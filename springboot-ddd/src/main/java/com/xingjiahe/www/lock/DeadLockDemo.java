package com.xingjiahe.www.lock;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/10/26 5:05 PM
 */
public class DeadLockDemo {

            public static void main(String args[]) {
                DeadLock d1 = new DeadLock(true);
                DeadLock  d2 = new DeadLock(false);
                new Thread(d1,"刘帅帅").start();
                new Thread(d2,"李美美").start();
            	}
}
