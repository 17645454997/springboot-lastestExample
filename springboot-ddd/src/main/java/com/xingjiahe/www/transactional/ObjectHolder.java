package com.xingjiahe.www.transactional;

/**
 * @author haisongzhe
 * @date 2022/12/17
 */
public class ObjectHolder<T> {

    private T object;

    public ObjectHolder(T object){
        this.object = object;
    }

    public T get() {
        return object;
    }

    public void set(T object) {
        this.object = object;
    }
}