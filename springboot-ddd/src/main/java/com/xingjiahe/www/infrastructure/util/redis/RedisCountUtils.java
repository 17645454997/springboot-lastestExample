//package com.xingjiahe.www.infrastructure.util.redis;
//
//import com.hellobike.base.redis.core.client.RedisClientManagement;
//import com.hellobike.base.redis.core.model.key.Key;
//import com.hellobike.config.redis.RedisLuaConsts;
//import com.hellobike.infrastructure.util.LogUtils;
//import org.apache.commons.lang.StringUtils;
//
//import java.time.Duration;
//import java.util.Arrays;
//
//public class RedisCountUtils {
//
//    public static Long incr(Key key, Duration duration) {
//        return (Long) RedisClientManagement.getInstance().evalSha(key, RedisLuaConsts.REDIS_COUNT_NAME,
//                Arrays.asList(key.getRawKey()), Arrays.asList(duration.getSeconds() + ""));
//    }
//
//    public static Long incrBy(Key key, Integer count, Duration duration) {
//        return (Long) RedisClientManagement.getInstance().evalSha(key, RedisLuaConsts.REDIS_COUNT_ANY_NAME,
//                Arrays.asList(key.getRawKey()), Arrays.asList(duration.getSeconds() + "", count + ""));
//    }
//
//    public static Long getValue(Key key) {
//        if(key == null) {
//            return 0L;
//        }
//
//        String value = RedisClientManagement.getInstance().get(key);
//
//        try {
//            if(StringUtils.isBlank(value)) {
//                return 0L;
//            }
//            return Long.parseLong(value);
//        } catch (Exception e) {
//            LogUtils.ERROR.error("RedisCountUtils-getLongValue-exception-key-{}", key.getRawKey(), e);
//        }
//
//        return 0L;
//    }
//}