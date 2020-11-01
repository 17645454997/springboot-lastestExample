package com.xingjiahe.www.infrastructure.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class LogUtils {

    // 一般的通用log
    public static final Logger COMMON = LogManager.getLogger("common");

    // 错误log
    public static final Logger ERROR = LogManager.getLogger("error");

    // 支付log
    public static final Logger PAY = LogManager.getLogger("pay");

    // 推送log
    public static final Logger PUSH = LogManager.getLogger("push");
}
