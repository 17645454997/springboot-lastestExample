package com.xingjiahe.www.controller;

import com.xingjiahe.www.handler.TestQueryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    TestQueryInfo testQueryInfo;
    @RequestMapping("/test")
    public  String test(){
     return  testQueryInfo.handle("a");
    }

}
