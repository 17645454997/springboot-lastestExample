package com.xingjiahe.www.interceptor;

import com.alibaba.fastjson.JSON;

import com.xingjiahe.www.aop.MetricAuth;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.lang.reflect.Method;
import java.net.SocketTimeoutException;

/**
 * @author hejaixing
 */
@Component
@Aspect
@Slf4j
@Order
public class MetricAuthInterceptor {
    @Around(value = "@annotation(metricAuth)")
    public Object process(ProceedingJoinPoint joinPoint, MetricAuth metricAuth) throws Throwable {
        String method = getMethod(joinPoint);
        Object[] param = getParam(joinPoint);
        String serviceType = metricAuth.value();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = methodSignature.getParameterNames();
        int userNewIdIndex = ArrayUtils.indexOf(parameterNames, "userNewId");
        Long userNewId = Long.parseLong(param[userNewIdIndex].toString());
        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            //log.error("invoke method = {} exception = {}", method, JSON.toJSONString(e));
            if (null != e && (e.getCause() instanceof ResourceAccessException || e.getCause() instanceof SocketTimeoutException)) {
          //      MetricLogUtils.toInterfaceRecordMetric(DateUtils.dataSourceFormatStr(), userNewId, serviceType, method);
            }
            return null;
        }
    }


    /**
     * get request param
     *
     * @param joinPoint
     * @return
     */
    private Object[] getParam(ProceedingJoinPoint joinPoint) {
        return joinPoint.getArgs();
    }

    /**
     * 拿到方法名
     *
     * @param joinPoint
     * @return
     */
    private String getMethod(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature ms = (MethodSignature) signature;
        Method m = ms.getMethod();
        return m.getName();
    }


}