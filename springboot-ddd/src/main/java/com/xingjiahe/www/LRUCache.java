package com.xingjiahe.www;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p></p>
 *
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
