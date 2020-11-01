package com.xingjiahe.www.infrastructure.util;

/**
 * Description
 * Copyright HelloBike
 *
 * @author limingjun
 * @version 1.0
 * @date 2018/10/17
 */
public class Response<T> {

    public static final String SUCCESS = "0";

    public static final String ORDER_CANCELED_RESULT = "164";

    public static final String ORDER_SERVICING_RESULT = "113";

    private String result;

    private String errmsg;

    private T data;

    public boolean isSuccess() {
        return result.equals(SUCCESS);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
