package com.xingjiahe.www.rule.engine;

import com.xingjiahe.www.domain.model.aggregates.Result;



/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/12/1 11:43 AM
 */
public interface Rule {
    /**
     * 执行规则
     * @param expression
     * @return
     */
    boolean  evaluate(Expression expression);

    /**
     * 获取执行结果
     * @return
     */
     Result  getResult();
}
