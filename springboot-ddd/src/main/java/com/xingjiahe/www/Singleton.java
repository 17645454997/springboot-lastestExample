package com.xingjiahe.www;

/**
 * <p>单例模式</p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/1/10 下午7:28
 */
public class Singleton {
    /**
     *  volatile 关键字防止因为java 内存模型指令重排序导致的多线程问题
     */
    private  static volatile Singleton instance = null;
    private  Singleton (){};
    public  static  Singleton getInstance(){
        if(null == instance){
            synchronized (Singleton.class){
                if(null == instance){
                    instance = new Singleton();
                }
            }
        }
        return  instance;
    }


}
