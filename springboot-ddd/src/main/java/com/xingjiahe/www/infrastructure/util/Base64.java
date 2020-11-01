//package com.xingjiahe.www.infrastructure.util;
//
//import java.io.UnsupportedEncodingException;
//
///**
// * @author xianqiugeng
// * 2019-09-30
// */
//public class Base64 {
//
//    /**
//     * Encode base 64.
//     *加密
//     * @param str the str
//     * @return the string
//     */
//    public static String encodeBase64(String str) {
//        byte[] strByte = null;
//        String result = null;
//        try {
//            strByte = str.getBytes("UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        byte[] encodeBase64 = org.apache.commons.codec.binary.Base64.encodeBase64(strByte);
//        if (encodeBase64 != null) {
//            result = new String(encodeBase64);
//        }
//        return result;
//    }
//
//    /**
//     * Decode base 64.
//     *解密
//     * @param str the str
//     * @return the string
//     */
//    public static String decodeBase64(String str) {
//        byte[] strByte = null;
//        String result = null;
//        try {
//            strByte = str.getBytes("UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        byte[] encodeBase64 = org.apache.commons.codec.binary.Base64.decodeBase64(strByte);
//        if (encodeBase64 != null) {
//            result = new String(encodeBase64);
//        }
//        return result;
//    }
//}
