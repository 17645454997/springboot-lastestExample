package com.jiaxinghe.www.strategy.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 4:10 PM
 */
@Component
public class FactoryDemo {

    @Autowired
    List<IFileResolveFactory> fileResolveFactory;

     public  FactoryDemo () {

     }


     public  void  factoryCreate(FileResolveEnum fileResolveEnum){

     }
}
