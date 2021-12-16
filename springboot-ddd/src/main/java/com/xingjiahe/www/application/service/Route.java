package com.xingjiahe.www.application.service;

import com.alibaba.fastjson.JSONObject;
import com.xingjiahe.www.domain.model.aggregates.Result;
import com.xingjiahe.www.interfaces.dto.EnumMethodName;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/16 上午10:53
 */
public interface Route {

    /**
     * 路由
     * @param params
     * @param methodName
     * @return
     */
     Result route(JSONObject params, EnumMethodName methodName);
}
