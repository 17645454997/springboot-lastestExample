package com.jiaxinghe.www.strategy.singleton;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 4:18 PM
 */
public enum SingletonEnum {

    /**
     * 单例对象
     */
    INSTANCE;

    public  SingletonEnum getInstance() {
        return INSTANCE;
    }

}
