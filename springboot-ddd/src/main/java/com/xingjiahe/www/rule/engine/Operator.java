package com.xingjiahe.www.rule.engine;

import lombok.Getter;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/12/1 2:13 PM
 */
@Getter
public enum Operator {

    /**
     * a  b  参数
     */
    ADD{
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    };

    public abstract int apply(int a, int b);
}
