//package com.xingjiahe.www.application.service.impl;
//
//import com.alibaba.fastjson.JSONObject;
//import com.xingjiahe.www.application.service.Route;
//import com.xingjiahe.www.domain.model.aggregates.Result;
//import com.xingjiahe.www.interfaces.dto.EnumMethodName;
//
///**
// * <p></p>
// *
// * @author hejiaxing
// * @version 1.0
// * @date 2021/12/16 上午11:02
// */
//public class RouteImpl implements Route {
//    @Override
//    public Result route(JSONObject params, EnumMethodName methodName) {
//       switch (methodName){
//           case JOURNEY:
//               return new Result(0,"JOURNEY",null,null);
//           case DISCOVER:
//               return new Result(0,"DISCOVER",null,null);
//       }
//       return new Result<>(0,"Error",null,null);
//    }
//    public RouteMeta  getRouteMeta(RouteMeta routeMeta){
//
//        return null;
//    }
//}
