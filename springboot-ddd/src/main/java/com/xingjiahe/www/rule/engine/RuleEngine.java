package com.xingjiahe.www.rule.engine;

import com.xingjiahe.www.domain.model.aggregates.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/12/5 11:12 AM
 */
public class RuleEngine {
    private  static final List<Rule> RULES = new ArrayList<>();

    static  {
        RULES.add(new AddRule());
    }

    public Result  process  (Expression  expression){
        Rule rule = RULES
                .stream()
                .filter(r->r.evaluate(expression))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("Expression does not  matches any rule"));
        return  rule.getResult();
    }
}
