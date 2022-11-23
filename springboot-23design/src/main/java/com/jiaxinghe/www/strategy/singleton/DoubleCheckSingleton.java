package com.jiaxinghe.www.strategy.singleton;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 4:14 PM
 */
public class DoubleCheckSingleton {

    private  volatile static DoubleCheckSingleton instance;

    private  DoubleCheckSingleton(){

    }

    public  static  DoubleCheckSingleton getInstance(){
       if(instance == null){
           synchronized (DoubleCheckSingleton.class){
               if(instance == null){
                   instance = new DoubleCheckSingleton();
               }
           }
       }
       return  instance;
    }

}
