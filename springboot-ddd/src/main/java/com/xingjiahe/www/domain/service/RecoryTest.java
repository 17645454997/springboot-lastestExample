package com.xingjiahe.www.domain.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.RetryException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
//import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hsw
 * @Date 17:29 2018/7/23
 */
@Slf4j
@EnableRetry
@Component
public class RecoryTest {

    public void test () {
        retry();
    }

    @Retryable(value = {RetryException.class},//指定发生的异常进行重试
            maxAttempts=5,                   //重试次数,默认即为3
            backoff = @Backoff(value = 2000))//每次重试延迟毫秒数
    public void retry () {
        log.info("retry start");
        throw new RetryException("retry fail");
    }

    @Recover
    public void recover (RetryException e) {
        log.info("recovery,{}",e.getMessage());

    }
}




