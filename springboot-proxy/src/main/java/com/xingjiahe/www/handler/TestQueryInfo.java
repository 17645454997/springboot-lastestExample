package com.xingjiahe.www.handler;

import com.alibaba.fastjson.JSONObject;
import com.xingjiahe.www.enms.EnumTestMethodType;
import org.springframework.stereotype.Service;

@Service
public class TestQueryInfo extends AbstractTestHandler implements  TestMethodHandler {


    @Override
    public <T> T handle(String req) {
        return (T)"ok";
    }

    @Override
    public EnumTestMethodType getMethod() {
        return EnumTestMethodType.QUERY_TEST_INFO;
    }
}
