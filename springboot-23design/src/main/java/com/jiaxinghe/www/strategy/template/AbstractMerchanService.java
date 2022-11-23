package com.jiaxinghe.www.strategy.template;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 */
public abstract class AbstractMerchanService {

    /**
     * 抽象类定义骨架流程（查询商户信息，加签，http请求，验签）
     * @param request
     * @return
     */
    Response handlerTemplate(final  Request request) {
        //查询商户信息
        queryMerChantInfo();
        //加签
        signature();
        //http  请求
        httpRequest();
        //验签
        verifySignature();
        return new Response();
    }

    /**
     * Http 是否走代理
     *
     * @return
     */
    abstract boolean isRequestByProxy();


    private void verifySignature() {

    }

    private void httpRequest() {

    }


    private void signature() {

    }

    private void queryMerChantInfo() {

    }
}
