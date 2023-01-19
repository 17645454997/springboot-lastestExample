package com.xingjiahe.www.exception;


import java.io.Serializable;

/**
 * @author haisongzhe
 * @date 2022/12/17
 */
public class Result<T> implements Serializable {
    private static final String SUC_MEG = "成功";
    private static final Integer SUC_CODE = 0;

    protected Boolean success;
    protected Integer errorCode;
    protected String errorMsg;
    protected T result;

    public Result() {

    }

    public Result(Builder<T>builder) {
        this.success = builder.success;
        this.errorCode = builder.errorCode;
        this.errorMsg = builder.errorMsg;
        this.result = builder.result;
    }



    public static <T> Result <T> newSucResponse() {
      return  new Builder().success(true)
              .errorCode(SUC_CODE)
              .errorMsg(SUC_MEG)
              .build();
    }
    public static <T> Result<T> newSuccResponse(T result) {
        return new Builder().success(true)
                .errorCode(SUC_CODE)
                .errorMsg(SUC_MEG)
                .result(result).build();
    }

    public static <T> Result<T> newFailResponse(Integer errorCode, String errorMsg) {
        return new Builder().success(false)
                .errorCode(errorCode)
                .errorMsg(errorMsg)
                .result(null).build();
    }


    public static  final  class Builder<T> {
        protected Boolean success;
        protected Integer errorCode;
        protected String errorMsg;
        protected T result;
    private Builder (){

    }
    public  Result build(){
        return  new Result(this);
    }
        public Builder success(Boolean success) {
            this.success = success;
            return this;
        }
        public Builder errorCode(Integer errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public Builder errorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }

        public Builder result(T result) {
            this.result = result;
            return this;
        }
    }

    public Boolean isSuccess() {
        return success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public T getResult() {
        return result;
    }
}
