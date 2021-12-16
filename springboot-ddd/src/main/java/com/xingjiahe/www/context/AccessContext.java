package com.xingjiahe.www.context;

import lombok.Data;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/16 上午10:35
 */
@Data
public class AccessContext {
    /**
     * 用户ID
     */
    private  Long userNewId;
    /**
     * 调用方法
     */
    private String method;
}
