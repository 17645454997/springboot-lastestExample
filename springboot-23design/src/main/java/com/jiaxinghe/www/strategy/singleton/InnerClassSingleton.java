package com.jiaxinghe.www.strategy.singleton;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 4:16 PM
 */
public class InnerClassSingleton {

    private  static  class  InnerClassSingletonHolder{
        private  static  final  InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    private  InnerClassSingleton(){}

    public  static  final  InnerClassSingleton getInstance(){
        return  InnerClassSingletonHolder.INSTANCE;
    }
}
