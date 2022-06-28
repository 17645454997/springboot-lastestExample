package com.xingjiahe.www;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
/*
  consumerGroup:消息组
  topic：消息话题
 */
@RocketMQMessageListener(consumerGroup = "provider", topic = "provider-topic")
//实现RocketMQ的监听接口
public class RocketMassageImpl implements RocketMQListener<String> {

    @Override
    public void onMessage(String str) {
        Map<String, Object> map = (Map<String, Object>) JSONObject.parse(str);
        log.info("您接受到一条新消息："+map);
        log.info("姓名："+map.get("name"));
        log.info("性别："+map.get("sex"));
        log.info("sql："+map.get("sql"));
    }
}
