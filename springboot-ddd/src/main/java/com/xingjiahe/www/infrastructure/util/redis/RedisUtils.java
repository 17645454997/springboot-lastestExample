//package com.xingjiahe.www.infrastructure.util.redis;
//
//import com.hellobike.base.redis.core.client.RedisClientManagement;
//import com.hellobike.base.redis.core.model.key.Key;
//
//public final class RedisUtils {
//
//    public static boolean setExAndNx(Key redisKey, String value, Long seconds) {
//        String set = RedisClientManagement.getInstance().set(redisKey, value, "NX", "EX", seconds);
//        return "OK".equals(set);
//    }
//
//}
