package com.xingjiahe.www.bloom;

import com.xingjiahe.www.utils.RedisTemplate;
import com.xingjiahe.www.utils.RedisUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.BitSet;



/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/6/23 4:09 PM
 */
@Service
public class MyBloomFilter {


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
    public static void add(String value) {
        if (value != null) {
            for (HashFunction f : functions) {
                //计算 hash 值并修改 bitmap 中相应位置为 true
                bitset.set(f.hash(value), true);
            }
        }
    }

    /**
     * 判断相应元素是否存在
     * @param value 需要判断的元素
     * @return 结果
     */
    public static boolean contains(String value) {
        if (value == null) {
            return false;
        }
        boolean ret = true;
        for (HashFunction f : functions) {
            ret = bitset.get(f.hash(value));
            //一个 hash 函数返回 false 则跳出循环
            if (!ret) {
                break;
            }
        }
        return ret;
    }

    /**
     * 测试
     */
    public static void main(String[] args) {

}
@Test
public  void  redisSetBitTest(){
    for (int i = 0; i < seeds.length; i++) {
        functions[i] = new HashFunction(DEFAULT_SIZE, seeds[i]);
    }

    // 添加1亿数据
    for (int i = 0; i < 100000000; i++) {
        add(String.valueOf(i));
    }
    System.out.println(contains("99999999"));   // true

    String id = "123456789";
    add(id);

    System.out.println(contains(id));   // true
    System.out.println("" + contains("234567890"));  //false
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
