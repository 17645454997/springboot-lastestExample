package com.xingjiahe.www.domain.service.concurrent;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/25 下午1:25
 */
public class IdGenerator {
    private  int value = 0;
    public int getNext(){
        return  value++;
    }
}
