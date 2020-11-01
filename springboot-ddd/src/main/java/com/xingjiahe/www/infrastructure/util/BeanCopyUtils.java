//package com.xingjiahe.www.infrastructure.util;
//
//import net.sf.cglib.beans.BeanCopier;
//import net.sf.cglib.core.Converter;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * Description
// * Copyright HelloBike
// *
// * @author limingjun
// * @version 1.0
// * @date 2018/12/10
// */
//public class BeanCopyUtils {
//
//    private static final Map<String, BeanCopier> BEAN_COPIER_MAP = new ConcurrentHashMap<>();
//
//    private BeanCopyUtils() {
//    }
//
//    public static BeanCopier getBeanCopier(Class<?> source, Class<?> target) {
//        String key = generateKey(source, target);
//        return BEAN_COPIER_MAP.computeIfAbsent(key, x -> BeanCopier.create(source, target, false));
//    }
//
//    public static void copy(Object source, Object target) {
//        getBeanCopier(source.getClass(), target.getClass()).copy(source, target, null);
//    }
//
//    public static void copy(Object source, Object target, Converter converter) {
//        getBeanCopier(source.getClass(), target.getClass()).copy(source, target, converter);
//    }
//
//    private static String generateKey(Class<?> source, Class<?> target) {
//        return source.getCanonicalName().concat(target.getCanonicalName());
//    }
//
//
//}
