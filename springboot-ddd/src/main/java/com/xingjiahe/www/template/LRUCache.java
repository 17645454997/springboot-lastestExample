package com.xingjiahe.www.template;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p></p>
 * 应用层  表示层 会话层 传输层 网络层 数据链路层 物理层
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/25 上午11:51
 */
public class LRUCache {

    class DLinkNode{
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
        public DLinkNode (){}
        public  DLinkNode (int key,int value){
            this.key = key;
            this.value = value;
        }
   }
    private Map<Integer,DLinkNode> cache = new HashMap<>();
    private  int  size;
    private int capacity;
    private  DLinkNode head,tail;

    public  LRUCache(int capacity){
        this.size =0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail  = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public   int get(int key){
        DLinkNode node  = cache.get(key);
        if(node == null){
            return  -1;
        }
        moveToHead(node);
        return  node.value;
    }

    public  void  put(int key,int value){
        DLinkNode node  = cache.get(key);
        if(node == null){
            DLinkNode  newNode = new DLinkNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if(size>capacity){
                DLinkNode tail  =removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }


    private void addToHead(DLinkNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private  void  removeNode(DLinkNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkNode node){
        removeNode(node);
        addToHead(node);
    }

    private DLinkNode removeTail(){
        DLinkNode res = tail.prev;
        removeNode(res);
        return  res;
    }
    public static void main(String args[]) {
        LRUCache lruCache =  new LRUCache(2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.put(5,5);
        lruCache.put(6,6);
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(6));
    	}
}
