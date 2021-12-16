package com.xingjiahe.www.domain.model.aggregates;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/16 上午10:54
 */
public class Result<T> implements Serializable {
    private static  final long serialVersionUID = -71392809092031238L;
    private static  final int OK_CODE = 0;
    public  static   final Result OK = new Result(OK_CODE,null,null,null);
    private final  int code;
    private final  String message;
    private final  T data;
    private final Throwable exception;

    public Result (int code ,String message ,T data ,Throwable exception){
        this.code = code;
        this.message = message;
        this.data = data;
        this.exception = exception;
    }


}
