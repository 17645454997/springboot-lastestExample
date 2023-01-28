package com.xingjiahe.www.exception;

/**
 * @author haisongzhe
 * @date 2022/12/17
 */
public enum ErrorCode implements IErrorCode {

    SUCCESS("0","成功"),
    FAIL("9999","失败"),
    SYSTEM_ERROR("2036","系统内部异常"),
    ;

    /**
     * 定义错误码范围,给对应的系统
     * 100-199 服务商
     */
    private final String desc;
    private final String code;

    ErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
