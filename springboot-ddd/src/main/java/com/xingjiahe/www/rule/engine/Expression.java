package com.xingjiahe.www.rule.engine;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/12/1 2:11 PM
 */
@Data
@AllArgsConstructor
public class Expression {
    private Integer x;
    private Integer y;
    private Operator operator;
}
