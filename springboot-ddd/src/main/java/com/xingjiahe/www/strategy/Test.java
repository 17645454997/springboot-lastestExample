package com.xingjiahe.www.strategy;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/16 3:13 PM
 */
public class Test {
    public static void main(String args[]) {
        AbstractCancelBeforeHandler cancelProcessHandler  = new CancelProcessHandler();
        Message message = new Message();
        message.setName("Hello");
        cancelProcessHandler.beforeProcess(message);
    	}
}
