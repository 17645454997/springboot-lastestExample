package com.xingjiahe.www.strategy;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/16 3:07 PM
 */
public  abstract  class AbstractCancelBeforeHandler {

    // 默认没有实现，由子类自定义扩展
    protected void beforeProcess(Message message) {
        if(("Hello").equals(message.getName())){
            return;
        }
    }

    // 由具体子类实现
    protected void preHandle(Message message) {
    }

    // 由具体子类实现
    protected abstract boolean doProcess(Message message);

    // 默认没有实现，由子类自定义扩展
    protected void afterProcess(Message message) {
        System.out.println("最初的后置处理器");
    }

}
