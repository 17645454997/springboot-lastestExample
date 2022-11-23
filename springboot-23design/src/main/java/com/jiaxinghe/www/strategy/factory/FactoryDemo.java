package com.jiaxinghe.www.strategy.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    IFileResolveFactory fileResolveFactory;

     public  void  factoryCreate(FileResolveEnum fileResolveEnum){
         switch (fileResolveEnum){
             case BFILE:
                 fileResolveFactory = new BFileResolve();
                 break;
             default:
                 fileResolveFactory = new AFileReslove();
         }
         fileResolveFactory.resolve();
     }
}
