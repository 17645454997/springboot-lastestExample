package com.xingjiahe.www;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:statusMachine.xml")
public class SpringbootDddApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDddApplication.class, args);
    }


}
