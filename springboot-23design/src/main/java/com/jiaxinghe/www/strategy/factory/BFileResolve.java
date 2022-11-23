package com.jiaxinghe.www.strategy.factory;

import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 4:05 PM
 */
@Component
public class BFileResolve implements  IFileResolveFactory{

    @Override
    public void resolve() {
    System.out.println("文件B类型解析");
    }
}
