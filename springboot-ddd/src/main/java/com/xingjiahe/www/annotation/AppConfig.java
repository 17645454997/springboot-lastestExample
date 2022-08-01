package com.xingjiahe.www.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/7/7 7:40 PM
 */
@Configuration
@ComponentScan({})
public class AppConfig {

    @Primary
    @Bean("userDao2")
    public UserDao userDao(){
        UserDao userDao = new UserDao();
        userDao.setLabel("2");
        return userDao;
    }
}
