//package com.xingjiahe.www.infrastructure.util;
//
//import com.alibaba.fastjson.JSONObject;
//
//import java.math.BigDecimal;
//
//public class RuleUtil {
//
//    public static int blameAmount(String startCityCode, String endCityCode, int price, JSONObject jsonObject){
//        if(startCityCode.equals(endCityCode)){
//            return jsonObject.getIntValue("innerLatePayment");
//        } else {
//            BigDecimal money = new BigDecimal(price).multiply(new BigDecimal(jsonObject.getString("crossPercent")));
//            if(money.intValue() > jsonObject.getIntValue("crossMax")){
//                return jsonObject.getIntValue("crossMax");
//            } else if(money.intValue() < jsonObject.getIntValue("crossMin")){
//                return jsonObject.getIntValue("crossMin");
//            } else {
//                return money.intValue();
//            }
//        }
//    }
//
//    public static int blameAmountGray(String startCityCode, String endCityCode, int price, JSONObject jsonObject){
//        if(startCityCode.equals(endCityCode)){
//            BigDecimal money = new BigDecimal(price).multiply(new BigDecimal(jsonObject.getString("innerPercent")));
//            if(money.intValue() > jsonObject.getIntValue("innerMax")){
//                return jsonObject.getIntValue("innerMax");
//            } else if(money.intValue() < jsonObject.getIntValue("innerMin")){
//                return jsonObject.getIntValue("innerMin");
//            } else {
//                return money.intValue();
//            }
//        } else {
//            BigDecimal money = new BigDecimal(price).multiply(new BigDecimal(jsonObject.getString("crossPercent")));
//            if(money.intValue() > jsonObject.getIntValue("crossMax")){
//                return jsonObject.getIntValue("crossMax");
//            } else if(money.intValue() < jsonObject.getIntValue("crossMin")){
//                return jsonObject.getIntValue("crossMin");
//            } else {
//                return money.intValue();
//            }
//        }
//    }
//}
