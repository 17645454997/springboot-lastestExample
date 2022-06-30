package com.xingjiahe.www.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * @author  hejiaxing
 * @desc
 */
@SpringBootApplication
public class DockerfileMavenPluginApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerfileMavenPluginApplication.class, args);
    }

    @RequestMapping("/hello")
    public  String hello(){
        return  "Hello,World";
    }

}
