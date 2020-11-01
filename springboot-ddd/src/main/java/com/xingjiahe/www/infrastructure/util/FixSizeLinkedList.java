package com.xingjiahe.www.infrastructure.util;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 固定长度的链表，超长自动从尾部删除
 * @param <T>
 */
public class FixSizeLinkedList<T> extends LinkedList<T> {

	private static final long serialVersionUID = 3292612616231532364L;

	// 定义缓存的容量
	private int capacity;

	public FixSizeLinkedList(int capacity) {
		super();
		this.capacity = capacity;
	}

	@Override
	public boolean add(T e) {
		// 超过长度，移除最后一个
		if (size() + 1 > capacity) {
			super.removeFirst();
		}
		return super.add(e);
	}

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (!Objects.isNull(c)) {
            for (T item : c) {
                add(item);
            }
            return true;
        } else {
            return false;
        }
    }

}