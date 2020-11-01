package com.xingjiahe.www.infrastructure.util;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by reach on 2018/8/31.
 */
public class MapUtils {

    /**
     * 按照 key 字符串对 map 排序
     * @param map
     * @return
     */
    public static Map<String, Object> sortMapByKey(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, Object> sortedMap = new TreeMap<>(String::compareTo);
        sortedMap.putAll(map);
        return sortedMap;
    }

    /**
     * 將 map 转换成字符串 k1=v1&k2=v2&...&kn=vn
     * @param map
     * @return
     */
    public static String spliceMapToString(Map<String, Object> map) {
        if (map.size() == 0){
            return null;
        }
        StringBuilder urlParam = new StringBuilder();
        for (Map.Entry<String, Object> ent : map.entrySet()) {
            if (null == ent.getValue()) {
                continue;
            }
            urlParam.append(ent.getKey()).append("=").append(ent.getValue()).append("&");
        }
        urlParam.deleteCharAt(urlParam.length() - 1);
        return urlParam.toString();
    }
}
