package com.xingjiahe.www.infrastructure.util.redis;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * RedisClientManagement 初始化
 */
@Configuration
public class RedisConfiguration {

    @PostConstruct
    public void init() {
//        new PathRedisInitializer()
//                .setAppId(PropUtils.getProperty("redis.appid"))
//                .setConfigServerHost(PropUtils.getProperty("redis.config.server"))
//                .setToken(PropUtils.getProperty("redis.token"))
//                .setPool(Utils.getPath("configs/redisConfig.json"), ConfigFormatter.JSON)
//                .init();
    }
}
