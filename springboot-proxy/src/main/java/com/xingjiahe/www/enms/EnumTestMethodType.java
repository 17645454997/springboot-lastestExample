package com.xingjiahe.www.enms;

import java.util.stream.Stream;


public enum EnumTestMethodType {
    QUERY_TEST_INFO("queryInfo","查询详情");
    private String code;
    private String desc;

    EnumTestMethodType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public EnumTestMethodType setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public EnumTestMethodType setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public static EnumTestMethodType parse(String method) {
        return Stream.of(values()).filter((methodType) -> methodType.getCode().equals(method)).findFirst().orElse(null);
    }
}
