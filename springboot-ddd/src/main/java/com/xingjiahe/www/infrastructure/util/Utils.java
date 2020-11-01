//package com.xingjiahe.www.infrastructure.util;
//
//import com.hellobike.BootStrap;
//import org.apache.commons.lang.time.DateUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.BeanWrapper;
//import org.springframework.beans.BeanWrapperImpl;
//
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import java.util.concurrent.ThreadLocalRandom;
//
///**
// * @Author: Rayee
// * @Date: 2018/9/6 下午10:45
// */
//public class Utils {
//
//    public static String[] getNullPropertyNames(Object source) {
//        final BeanWrapper src = new BeanWrapperImpl(source);
//        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
//
//        Set<String> emptyNames = new HashSet<>();
//        for (java.beans.PropertyDescriptor pd : pds) {
//            Object srcValue = src.getPropertyValue(pd.getName());
//            if (srcValue == null) {
//                emptyNames.add(pd.getName());
//            }
//        }
//        String[] result = new String[emptyNames.size()];
//        return emptyNames.toArray(result);
//    }
//
//    public static String getPath(String path) {
//        File fDir = new File(BootStrap.class.getResource("/").getPath());
//        String p = fDir.getAbsolutePath();
//        //本地启动配置
//        path = p.replace("\\", "/") + "/" + path;
//        return path;
//    }
//
//    /**
//     * 订单GUID，系统间交互使用（分表键）
//     *
//     * @param userNewId
//     * @return
//     */
//    public static String genOrderGuid(String userNewId) {
//        String timeStampStr = String.valueOf(System.currentTimeMillis());
//        String userNewIdStr = String.valueOf(userNewId);
//        return timeStampStr.concat(userNewIdStr);
//    }
//
//    /**
//     * 订单ID，展示用
//     *
//     * @param userNewId
//     * @return
//     */
//    public static String genOrderId(String userNewId) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        StringBuilder orderId = new StringBuilder("");
//        orderId.append(sdf.format(new Date()));
//        orderId.append("-");
//        orderId.append(userNewId);
//        orderId.append("-");
//        orderId.append(getFourRandomNo());
//        return orderId.toString();
//    }
//
//
//    public static String getFourRandomNo() {
//        int max = 9999;
//        int min = 1000;
//        int s = ThreadLocalRandom.current().nextInt(max) % (max - min + 1) + min;
//        return String.valueOf(s);
//    }
//
//    public static String uuid() {
//        return UUID.randomUUID().toString().replaceAll("-", "");
//    }
//
//    /**
//     * 支付流水订单ID
//     *
//     * @param userNewId
//     * @return
//     */
//    public static String genPaymentGuid(Long userNewId) {
//        String timeStampStr = String.valueOf(System.currentTimeMillis());
//        String userNewIdStr = String.valueOf(userNewId);
//        return timeStampStr.concat(userNewIdStr);
//    }
//
//    public static Integer getDailyRemainingSec() {
//        Long l = 86400 - DateUtils.getFragmentInSeconds(Calendar.getInstance(), Calendar.DATE);
//        return l.intValue();
//    }
//
//    /**
//     * 通过身份证号获取出生日期 yyyy-mm-dd
//     * @param idCard
//     * @return
//     */
//    public static String getIdCardBirth(String idCard){
//        if(StringUtils.isEmpty(idCard) || idCard.length() < 14){
//            return null;
//        }
//        String year;
//        if(15 == idCard.length()) {
//            year = "19" + idCard.substring(6, 12);
//        } else {
//            year = idCard.substring(6, 14);
//        }
//        StringBuilder sb = new StringBuilder(year);
//        sb.insert(4, "-").insert(7, "-");
//        return sb.toString();
//    }
//
//    /**
//     * 获取处理好的手机号码 137****1155
//     * @param mobilePhone
//     * @return
//     */
//    public static String getHandleMobilePhone(String mobilePhone){
//        if(StringUtils.isEmpty(mobilePhone) || mobilePhone.length() < 4){
//            //非法
//            return null;
//        }
//        StringBuilder sb = new StringBuilder(mobilePhone.substring(0,3));
//        sb.append("****");
//        if(mobilePhone.length() <= 7){
//            return sb.toString();
//        }
//        //截取后4位
//        sb.append(mobilePhone.substring(mobilePhone.length()-4,mobilePhone.length()));
//        return sb.toString();
//    }
//
//    /**
//     * 获取年龄标签
//     * @param idCard
//     * @return
//     */
//    public static String getAgeLabelByIdCard(String idCard){
//        return getAgeLabelByIdCardBirth(getIdCardBirth(idCard));
//    }
//
//    /**
//     * 获取年龄标签
//     * @param idCardBirth
//     * @return
//     */
//    public static String getAgeLabelByIdCardBirth(String idCardBirth){
//        if(StringUtils.isEmpty(idCardBirth) || idCardBirth.length() < 3){
//            //非法
//            return null;
//        }
//        return idCardBirth.substring(2,3).concat("0后");
//    }
//
//}
