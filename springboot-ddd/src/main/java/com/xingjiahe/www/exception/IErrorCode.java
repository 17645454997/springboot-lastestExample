package com.xingjiahe.www.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * @author haisongzhe
 * @date 2022/12/17
 */
public interface IErrorCode {

    /**
     * 获取错误嘛
     * @return 错误码
     */
    String getCode();

    /**
     * 获取错误信息
     * @return
     */
    String getDesc();


    /**
     *
     * 替换错误码信息
     * @param errorCode
     * @param desc
     * @return
     */
    static IErrorCode  create(ErrorCode errorCode,String desc){
        return  new DefaultErrorCode(errorCode.getCode(),desc);
    }

    /**
     * 创建错误码
     * @param error
     * @return
     */
    static IErrorCode create(ErrorCode error){return error;}


    static IErrorCode create(Integer errorCode ,String errorMsg){
        if(errorCode == null){
            return  new DefaultErrorCode("",errorMsg);
        }
        return new DefaultErrorCode(errorCode.toString(),errorMsg);
    }

    static IErrorCode create(String errorCode,String errorMsg){
        return  new DefaultErrorCode(errorCode,errorMsg);
    }

    @Getter
    @AllArgsConstructor
    class  DefaultErrorCode implements IErrorCode{
        private String code;
        private String desc;

    }
}
