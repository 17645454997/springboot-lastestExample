package com.xingjiahe.www.current;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/15 8:26 PM
 */
public class NoVisbility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String args[]) {
             new ReaderThread().start();
             number = 42;
             ready = true;
    	}
}
