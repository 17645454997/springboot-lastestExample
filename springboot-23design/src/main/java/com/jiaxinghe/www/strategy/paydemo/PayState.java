package com.jiaxinghe.www.strategy.paydemo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PayState {
    private Integer code;
    private Object data;
    private String msg;

    public PayState(Integer code, String msg, Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }


    public PayState(int code, String msg, String s1) {
        this.code = code;
        this.data = s1;
        this.msg = msg;
    }
}
