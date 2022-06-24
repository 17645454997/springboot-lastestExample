package com.xingjiahe.www.controller;


import com.xingjiahe.www.mapper.UserAuthEntityMapper;
import com.xingjiahe.www.utils.RedisTemplate;
import com.xingjiahe.www.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import java.util.List;

/**
 * @ClassName: RedisTestController
 * @Auther: zhangyingqi
 * @Date: 2018/8/28 17:24
 * @Description:
 */
@RestController
public class RedisTestController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    UserAuthEntityMapper mapper;

    /**
     * @auther: zhangyingqi
     * @date: 17:26 2018/8/28
     * @param: []
     * @return: org.springframework.ui.ModelMap
     * @Description: 测试redis存储&读取
     */
    @RequestMapping(value = "/test")
    public String test() {

        List <Long>list = redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (int i = 0; i < 100; i++) {
                    String key = "123" + i;
                    redisConnection.zCount(key.getBytes(StandardCharsets.UTF_8), 0, Integer.MIN_VALUE);
                }
                return null;
            }
        });

        for (int i = 0; i < seeds.length; i++) {
            functions[i] = new HashFunction(DEFAULT_SIZE, seeds[i]);
        }
        for (int i = 0; i < 100; i++) {
            add("bloomFilter",String.valueOf(i));
        }
        System.out.println(contains("bloomFilter","9999"));   // true
        String id = "12345";
        add("bloomFilter",id);
        System.out.println(contains("bloomFilter",id));   // true
        System.out.println("" + contains("bloomFilter","909090909"));  //false

        return "ok";

    }

    /**
     * 一个长度为10 亿的比特位
     */
    private static final int DEFAULT_SIZE = 256 << 22;

    /**
     * 为了降低错误率，使用加法hash算法，所以定义一个8个元素的质数数组，相当于构建 8 个不同的hash算法
     */
    private static final int[] seeds = {3, 5, 7, 11, 13, 31, 37, 61};

    /**
     * 相当于构建 8 个不同的hash算法
     */
    private static HashFunction[] functions = new HashFunction[seeds.length];

    /**
     * 初始化布隆过滤器的 bitmap
     */
    private static BitSet bitset = new BitSet(DEFAULT_SIZE);

    /**
     * 添加数据
     *
     * @param value 需要加入的值
     */
    public  void add(String key,String value) {
        if (value != null) {
            for (HashFunction f : functions) {
                redisTemplate.opsForValue().setBit(key,f.hash(value), true);
            }
        }
    }

    /**
     * 判断相应元素是否存在
     * @param value 需要判断的元素
     * @return 结果
     */
    public  boolean contains(String key,String value) {
        if (value == null) {
            return false;
        }
        boolean ret = true;
        for (HashFunction f : functions) {
            ret = redisTemplate.opsForValue().getBit(key,f.hash(value));
            //一个 hash 函数返回 false 则跳出循环
            if (!ret) {
                break;
            }
        }
        return ret;
    }
}

class HashFunction {

    private int size;
    private int seed;

    public HashFunction(int size, int seed) {
        this.size = size;
        this.seed = seed;
    }

    public int hash(String value) {
        int result = 0;
        int len = value.length();
        for (int i = 0; i < len; i++) {
            result = seed * result + value.charAt(i);
        }
        return (size - 1) & result;
    }


    /**
     * @param n 预计插入的元素
     * @param p 误判率（0 < p < 1）
     */
    long optimalNumOfBits(long n, double p) {
        if (p == 0) {
            p = Double.MIN_VALUE;
        }
        return (long) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));
    }

}

