package com.xingjiahe.www.bloom;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/6/23 3:32 PM
 */
public class BloomFilterTest {
       @Test
      public  void  testRedissonBloom(){
              // connects to 127.0.0.1:6379 by default
              RedissonClient redisson = Redisson.create();

              RBloomFilter<String> bloomFilter = redisson.getBloomFilter("bloomFilter");
              bloomFilter.tryInit(1000, 0.03);

              bloomFilter.add("a");
              bloomFilter.add("b");
              bloomFilter.add("c");
              bloomFilter.add("d");

              bloomFilter.getExpectedInsertions();
              bloomFilter.getFalseProbability();
              bloomFilter.getHashIterations();

              bloomFilter.contains("a");
               System.out.println( bloomFilter.contains("a"));
               System.out.println( bloomFilter.contains("c"));
               System.out.println( bloomFilter.contains("h"));
              bloomFilter.count();

              redisson.shutdown();
      }

        @Test
        public void testGuavaBloom() {
                // 初始化一个存储string数据的布隆过滤器，初始化大小1w, 错误率为0.1%
                BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 10000, 0.001);

                // 添加数据
                bloomFilter.put("hello world!");

                // 判断是否存在，false则表示一定不存在； true表示可能存在
                boolean ans = bloomFilter.mightContain("hello world!");
                System.out.println(ans);

                ans = bloomFilter.mightContain("hello world");
                System.out.println(ans);
        }
}
