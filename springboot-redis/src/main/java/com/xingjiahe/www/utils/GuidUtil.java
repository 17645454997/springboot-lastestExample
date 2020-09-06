package com.xingjiahe.www.utils;


import java.util.UUID;

/**
 * 代码生成GUID主键<br>
 * 〈功能详细描述〉
 */
public class GuidUtil {


    /**
     *
     * 功能描述: <br>
     * 主键生成器32位
     *
     * @return
     */
    public static final synchronized String getUUID() {
        String uuid = UUID.randomUUID().toString();
        StringBuilder sb = new StringBuilder(32);
        sb.append(uuid.substring(0, 8));
        sb.append(uuid.substring(9, 13));
        sb.append(uuid.substring(14, 18));
        sb.append(uuid.substring(19, 23));
        sb.append(uuid.substring(24, 36));
        return sb.toString();
    }
}

