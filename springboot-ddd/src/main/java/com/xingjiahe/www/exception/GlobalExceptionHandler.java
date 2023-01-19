package com.xingjiahe.www.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author haisongzhe
 * @date 2022/12/17
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 基础异常
     */
    @ExceptionHandler(Exception.class)
    public String baseException(Exception e){
        return  e.getMessage();
    }
    @ExceptionHandler()
    public Result baseBusException(){
        return  new Result<>();
    }

}
