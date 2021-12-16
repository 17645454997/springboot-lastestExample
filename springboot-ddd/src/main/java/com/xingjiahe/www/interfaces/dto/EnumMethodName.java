package com.xingjiahe.www.interfaces.dto;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/16 上午10:49
 */
public enum EnumMethodName {

    JOURNEY("journeyList"),
    DISCOVER("discover");

    private String method;

    EnumMethodName(String method) {
        this.method = method;
    }
}
