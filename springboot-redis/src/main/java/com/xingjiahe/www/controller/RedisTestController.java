package com.xingjiahe.www.controller;


import com.xingjiahe.www.mapper.UserAuthEntityMapper;
import com.xingjiahe.www.model.UserAuthEntity;
import com.xingjiahe.www.utils.GuidUtil;
import com.xingjiahe.www.utils.NumUtil;
import com.xingjiahe.www.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @ClassName: RedisTestController
 * @Auther: zhangyingqi
 * @Date: 2018/8/28 17:24
 * @Description:
 */

@Controller
@RequestMapping("/redis")
public class RedisTestController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    UserAuthEntityMapper mapper;

     int count=0;
    /**
     * @auther: zhangyingqi
     * @date: 17:26 2018/8/28
     * @param: []
     * @return: org.springframework.ui.ModelMap
     * @Description: 测试redis存储&读取
     */
    @RequestMapping(value = "/test")
    @ResponseBody
    public String test() {
 //       try {
//            for(int i=0;i<10000;i++){
//                int type;
//                boolean flag;
//                if(i%2==0){
//                    type=4;
//                    flag=false;
//                }else {
//                    type=6;
//                    flag=true;
//                }
//                redisUtil.set("DriverLifeSkipAuthForKingRedisKey:uerGuid:"+GuidUtil.getUUID()+":"+"type:"+type,flag ,0);
//            }
            Set<String> set = new HashSet<>();
            Random random = new Random();
            set = scan("DriverLifeSkipAuthForKingRedisKey");
              //  String value = redisUtil.get("DriverLifeSkipAuthForKingRedisKey:uerGuid:00138d62f761416eb94a7148add91f06:type:4", 0).toString();
            System.out.println(set.size());

            redisTemplate.execute((RedisCallback<Set<String>>) connection -> {
                Set<String> keysTmp = new HashSet<>();
                Cursor<byte[]> cursor = connection.scan(new ScanOptions.ScanOptionsBuilder().match("*" + "DriverLifeSkipAuthForKingRedisKey" + "*").count(1000).build());
                while (cursor.hasNext()) {
                    String[] splits = new String(cursor.next()).split(":");
                    UserAuthEntity userAuthEntity = new UserAuthEntity();
                    userAuthEntity.setUserNewId(NumUtil.getUUID());
                    userAuthEntity.setType(splits[4]);
                    userAuthEntity.setUserGuid(splits[2]);
                    userAuthEntity.setGuid(GuidUtil.getUUID());
                //    userAuthEntity.setFlag(redisUtil.get(new String(cursor.next()), 0).equals(true));
                    mapper.insert(userAuthEntity);
                    count++;
                }
                try {
                    cursor.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
//
                return keysTmp;
            });
//            set.forEach(e -> {
//                UserAuthEntity userAuthEntity = new UserAuthEntity();
//                String[] splits = e.split(":");
//                userAuthEntity.setUserNewId(NumUtil.getUUID());
//                userAuthEntity.setType(splits[4]);
//                userAuthEntity.setUserGuid(splits[2]);
//                userAuthEntity.setGuid(GuidUtil.getUUID());
//                userAuthEntity.setFlag(redisUtil.get(e, 0).equals(true));
//                mapper.insert(userAuthEntity);
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
          System.out.println(count);
        return "ok";

    }




    public Set<String> scan(String matchKey) {
        Set<String> keys = (Set<String>) redisTemplate.execute((RedisCallback<Set<String>>) connection -> {
            Set<String> keysTmp = new HashSet<>();
            Cursor<byte[]> cursor = connection.scan(new ScanOptions.ScanOptionsBuilder().match("*" + matchKey + "*").count(1000).build());
            while (cursor.hasNext()) {
                keysTmp.add(new String(cursor.next()));
            }
            try {
                cursor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return keysTmp;
        });

        return keys;
    }

}

