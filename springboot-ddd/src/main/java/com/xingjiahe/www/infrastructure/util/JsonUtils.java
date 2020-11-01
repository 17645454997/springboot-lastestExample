//package com.xingjiahe.www.infrastructure.util;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
///**
// * create by zmm 弄死熊猫
// * <p>
// * on 2018/8/27
// */
//public class JsonUtils {
//
//
//    /**
//     * 获取json字符串的value // TODO: 2018/8/27 后期做自定义解析器
//     *
//     * @return
//     */
//    public static String getValue(JSONObject object, String key) {
//        return object.getString(key);
//    }
//
//    public static Integer getInt(JSONObject object, String key) {
//        return object.getInteger(key);
//    }
//
//    /**
//     * bean to json
//     *
//     * @param t
//     * @param <T>
//     * @return
//     */
//    public static <T> String toJsonString(T t) {
//        return JSONObject.toJSONString(t);
//    }
//
//    public static <T> T fromJson(String json, Class<T> clazz) {
//        return JSON.parseObject(json, clazz);
//    }
//
//    public static <T> List<T> fromListJson(String json, Class<T> clazz) {
//        return JSON.parseArray(json, clazz);
//    }
//
//    public static <T> T fromJsonObject(JSONObject object, Class<T> clazz) {
//        return JSON.parseObject(object.toJSONString(), clazz);
//    }
//
//    public static Map<String, Object> toMap(JSONObject obj) {
//        Map<String, Object> result = new HashMap<String, Object>();
//        Set<String> keySet = obj.keySet();
//        keySet.forEach(each -> result.put(each, obj.get(each)));
//        return result;
//    }
//
//    public static JSONObject toJsonObject(Object o) {
//    	return JSONObject.parseObject(toJsonString(o));
//    }
//}
