package com.xingjiahe.www.strategy;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/16 3:06 PM
 */
public  class CancelProcessHandler  extends AbstractCancelBeforeHandler{

    @Override
    protected void beforeProcess(Message message) {
        super.beforeProcess(message);
        System.out.println("Hello");
    }

    @Override
    protected void preHandle(Message message) {
        super.preHandle(message);
    }

    @Override
    protected boolean doProcess(Message message) {
        return false;
    }

    @Override
    protected void afterProcess(Message message) {
        super.afterProcess(message);
    }
}
