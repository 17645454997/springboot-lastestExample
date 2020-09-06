package com.xingjiahe.www.handler;

import com.alibaba.fastjson.JSONObject;

public interface TestMethodHandler extends  TestMethodRegister{

    /**
     * 处理器
     *
     * @param req
     * @param <T>
     * @return
     */
    <T> T handle(String req);

}
