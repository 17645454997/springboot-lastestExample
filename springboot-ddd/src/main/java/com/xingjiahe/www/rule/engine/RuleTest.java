package com.xingjiahe.www.rule.engine;

import com.xingjiahe.www.domain.model.aggregates.Result;
import org.junit.Test;




/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/12/5 11:20 AM
 */
public class RuleTest {

   @Test
    public  void  ruleTest(){
        Expression expression  = new Expression(5,5,Operator.ADD);
        RuleEngine engine  = new RuleEngine();
       Result  result    = engine.process(expression);

    }
}
