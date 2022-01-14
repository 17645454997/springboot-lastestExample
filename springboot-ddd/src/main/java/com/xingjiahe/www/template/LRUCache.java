package com.xingjiahe.www.template;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p></p>
 * 应用层  表示层 会话层 传输层 网络层 数据链路层 物理层
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/25 上午11:51
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }
    public int get (int key){
       return  super.getOrDefault(key,-1);
    }
    public  void  put(int key,int value){
       super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return  size()> capacity;
    }
}