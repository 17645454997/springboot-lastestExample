package com.jiaxinghe.www.strategy.factory;


import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 4:04 PM
 */
@Component
public class AFileReslove implements  IFileResolveFactory{


    @Override
    public void resolve() {
    System.out.println("文件A类型解析");
    }
}
