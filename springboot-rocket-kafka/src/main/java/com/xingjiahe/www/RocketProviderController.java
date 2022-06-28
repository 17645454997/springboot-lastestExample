package com.xingjiahe.www;



import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("rocketmq")
public class RocketProviderController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @PostMapping
    public String test(@RequestBody Map<String,Object> map){
        //获取数据
        String data = (String)map.get("data");
        //发送数据
        rocketMQTemplate.convertAndSend("provider-topic",map);
        return "success";
    }
}



