package com.xingjiahe.www.optional;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Supplier;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/21 11:10 AM
 */
@Data
@AllArgsConstructor
public class ServiceException extends  RuntimeException implements Supplier<ServiceException>{

    private   Integer code;
    private  String message;
    @Override
    public ServiceException get() {
        return new ServiceException(code,message);
    }
}
