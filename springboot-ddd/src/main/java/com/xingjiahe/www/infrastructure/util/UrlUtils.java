//package com.xingjiahe.www.infrastructure.util;
//
//import com.hellobike.constant.Consts;
//import com.hellobike.infrastructure.component.send.enums.EnumDiverLinkUrl;
//import com.hellobike.infrastructure.component.send.enums.EnumSystemType;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//
//public final class UrlUtils {
//    ////订单详情页||订单详情待支付页面
//    public static final String getOrderDetailUrl(String orderGuid) throws UnsupportedEncodingException {
//        return "alipays://platformapi/startapp?appId=2017050407110255&query=" + URLEncoder.encode("redirectUrl=" + URLEncoder.encode("/pages/free-ride/views/order/order?orderGuid=" + orderGuid, "utf-8"));
//    }
//
//    //行程的匹配页
//    public static final String getOrderMatchUrl(String orderGuid) throws UnsupportedEncodingException {
//        return "alipays://platformapi/startapp?appId=2017050407110255&query=" + URLEncoder.encode("redirectUrl=" + URLEncoder.encode("/pages/free-ride/views/waiting-order/waiting-order?orderGuid=" + orderGuid, "utf-8"));
//    }
//
//    //行程的取消详情页
//    public static final String getOrderCancelUrl(String orderGuid) throws UnsupportedEncodingException {
//        return "alipays://platformapi/startapp?appId=2017050407110255&query=" + URLEncoder.encode("redirectUrl=" + URLEncoder.encode("/pages/free-ride/views/tool-end/tool-end?orderGuid=" + orderGuid, "utf-8"));
//    }
//
//    public static String builderUrl(EnumDiverLinkUrl enumLinkUrl, String... params) throws UnsupportedEncodingException {
//        EnumSystemType enumSystemType = enumLinkUrl.getEnumSystemType();
//        switch (enumSystemType) {
//            case ALIPAY:
//                return buildALiPayLinkUrl(enumLinkUrl.getLink(), params);
//            case APP:
//                return buildAppLinkUrl(enumLinkUrl.getLink(), params);
//        }
//        return null;
//    }
//
//    public static String builderPaxUrl(EnumDiverLinkUrl enumLinkUrl, String... params) throws UnsupportedEncodingException {
//        EnumSystemType enumSystemType = enumLinkUrl.getEnumSystemType();
//        switch (enumSystemType) {
//            case ALIPAY:
//                return buildALiPayLinkUrl(enumLinkUrl.getLink(), params);
//            case APP:
//                return buildAppPaxLinkUrl(enumLinkUrl.getLink(), params);
//        }
//        return null;
//    }
//
//    public static String builderUrl(EnumDiverLinkUrl enumLinkUrl) throws UnsupportedEncodingException {
//        return builderUrl(enumLinkUrl, null);
//    }
//
//    public static String buildALiPayLinkUrl(String url, String... params) throws UnsupportedEncodingException {
//        String dynamicUrl = buildPlaceHolder(url, params);
//
//        return "alipays://platformapi/startapp?appId=2017050407110255&query=" + URLEncoder.encode("redirectUrl=" + URLEncoder.encode("/pages/free-ride/views" + dynamicUrl, "utf-8"));
//    }
//
//    public static String buildAppLinkUrl(String url, String... params) throws UnsupportedEncodingException {
//        String dynamicUrl = buildPlaceHolder(url, params);
//        if(params != null && params.length > 0) {
//        	dynamicUrl = dynamicUrl + "&type=2&from=" + Consts.PLACE_HOLDER;
//        }
//
//        return "hellobike://hellobike.com" + dynamicUrl;
//    }
//
//    public static String buildAppPaxLinkUrl(String url, String... params) throws UnsupportedEncodingException {
//        String dynamicUrl = buildPlaceHolder(url, params);
//        if(params != null && params.length > 0) {
//            dynamicUrl = dynamicUrl + "&type=1&from=" + Consts.PLACE_HOLDER;
//        }
//
//        return "hellobike://hellobike.com" + dynamicUrl;
//    }
//
//    private static String buildPlaceHolder(String url, String... params) {
//    	if(params != null && params.length > 0) {
//    		for (int i = 0, size = params.length; i < size; i++) {
//                url = url.replace("{" + i + "}", params[i]);
//            }
//    	}
//
//        return url;
//    }
//
//    public static String buildAppInnerH5Url(String url) {
//        return "hellobike://hellobike.com/openWeb?webUrl=".concat(url);
//    }
//}
