//package com.xingjiahe.www.infrastructure.util;
//
//import cn.hutool.crypto.SecureUtil;
//
//import java.util.Map;
//
///**
// * 首汽签名算法工具类
// */
//public class SignUtil {
//
//    /**
//     * @param  mapParams
//     * @return signValue
//     */
//    public static String sign(Map<String, Object> mapParams) {
//        String sqycKey = com.hellobike.infrastructure.util.PropUtils.getProperty("sqycKey");
//        String channel = com.hellobike.infrastructure.util.PropUtils.getProperty("channel");
//        mapParams.put("channel",channel);
//        Map<String, Object> sortMap = MapUtils.sortMapByKey(mapParams);
//        String sortParStr = MapUtils.spliceMapToString(sortMap);
//        String params = sortParStr.concat("&sqycKey=").concat(sqycKey);
//        return SecureUtil.md5(params);
//    }
//}
