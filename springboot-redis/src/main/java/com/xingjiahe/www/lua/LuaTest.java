package com.xingjiahe.www.lua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class LuaTest {

    @Autowired
    RedisTemplate redisTemplate;

    // lua 脚本
   private String script= "local number = ARGV[1] \n"+
    "local gsave = redis.call('hget','goods_'..KEYS[1],'gsave')\n"+
            "if gsave < number then \n" +
            "return 2 \n"+
            "end \n"+
            "gsave = gasve -number \n"+
            "redis.call('hset','goods'..KEYS[1],'gsave',gsave)\n";

}
