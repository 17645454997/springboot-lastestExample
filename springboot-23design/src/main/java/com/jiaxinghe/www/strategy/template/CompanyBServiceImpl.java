package com.jiaxinghe.www.strategy.template;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 2:48 PM
 */
public class CompanyBServiceImpl extends AbstractMerchanService{

    @Override
    Response handlerTemplate(Request request) {
        return super.handlerTemplate(request);
    }

    @Override
    boolean isRequestByProxy() {
        return false;
    }
}
