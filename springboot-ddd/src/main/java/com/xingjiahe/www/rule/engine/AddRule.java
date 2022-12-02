package com.xingjiahe.www.rule.engine;

import com.xingjiahe.www.domain.model.aggregates.Result;



/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/12/1 11:46 AM
 */
public class AddRule implements  Rule{
    @Override
    public boolean evaluate(Expression expression) {
        boolean evaResult = false;
        if(expression.getOperator() == Operator.ADD){

        }
        return false;
    }

    @Override
    public Result getResult() {
        return null;
    }
}
