package com.xingjiahe.www.filter;

/**
 * <p>过滤链</p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/16 上午10:30
 */
public interface BaseFilter<T> {

    /**
     * 过滤链
     * @param context
     */
    void filter(T context);
}
