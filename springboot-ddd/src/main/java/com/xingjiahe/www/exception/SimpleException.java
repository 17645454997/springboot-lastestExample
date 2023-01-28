package com.xingjiahe.www.exception;

import com.google.common.base.Joiner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

/**
 * @author haisongzhe
 * @date 2022/12/17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class SimpleException extends RuntimeException implements Serializable {
    private static final long serialVersionUID =  -309386415202079995L;
    
    private  IErrorCode errorCode;
    
    private  String errorMsg;

    /**
     * 该异常被(mq)捕捉到后是否要触发重试
     */
    protected boolean needRetry = true;
    /**
     * 该异常被捕捉之后是否需要打印exception,默认需要
     */
    protected boolean needLogError = true;


    /**
     * 异常名称
     */
    private String exceptionName;

    /**
     * monitor上报异常的备注信息，非必要
     */
    private String remark;

    /**
     * 若为false则告警只上报exceptionName，否则上报exceptionName+errorCode，默认为true
     */
    private Boolean isMonitorCompleteName = true;

    /**
     * 若为false则告警只上报exceptionName，否则上报exceptionName+errorCode
     * LogisticsFrontendExceptionBuilder中创建的isMonitorFullName默认为true
     */
    private Boolean isMonitorFullName = true;

    @Override
    public String getMessage() {
        String errorCodeMsg = Optional.ofNullable(errorCode).map(e -> e.toString()).orElse(null);
        return Joiner.on(";").skipNulls().join(errorCodeMsg, errorMsg, super.getMessage());
    }

    public SimpleException(String exceptionName, IErrorCode errorCode, Throwable throwable){
        super(throwable);
        this.exceptionName = exceptionName;
        this.errorCode = errorCode;
        this.errorMsg = errorCode.getDesc();
    }

    public SimpleException(ErrorCode errorCode) {
        super(errorCode.getDesc());
        this.errorCode = errorCode;
        this.errorMsg = errorCode.getDesc();
    }

    public SimpleException(ErrorCode errorCode, Boolean needRetry) {
        super(errorCode.getDesc());
        this.errorCode = errorCode;
        this.errorMsg = errorCode.getDesc();
        this.needRetry = needRetry;
    }

    public SimpleException(ErrorCode errorCode,Throwable throwable) {
        super(errorCode.getDesc(), throwable);
        this.errorCode = errorCode;
        this.errorMsg = errorCode.getDesc();
    }

    public SimpleException(ErrorCode errorCode, String errorMsg) {
        super(errorCode.toString() + ":" + errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }



    /**
     * LogisticsConsoExceptionBuilder构建者
     */
    public static class SimpleExceptionBuilder {

        private final SimpleException SimpleException;

        public SimpleExceptionBuilder(String exceptionName, IErrorCode errorCode, Throwable cause) {
            SimpleException = new SimpleException(exceptionName, errorCode, cause);
        }

        public SimpleExceptionBuilder errorMsg(String errorMsg) {
            SimpleException.errorMsg = errorMsg;
            return this;
        }

        public SimpleExceptionBuilder errorCode(IErrorCode errorCode) {
            SimpleException.errorCode = errorCode;
            return this;
        }

        public SimpleExceptionBuilder needRetry(boolean needRetry) {
            SimpleException.needRetry = needRetry;
            return this;
        }

        public SimpleExceptionBuilder needLogError(boolean needLogError) {
            SimpleException.needLogError = needLogError;
            return this;
        }

        public SimpleExceptionBuilder remark(String remark) {
            SimpleException.remark = remark;
            return this;
        }

        public SimpleExceptionBuilder isMonitorCompleteName(Boolean isMonitorCompleteName) {
            SimpleException.isMonitorCompleteName = isMonitorCompleteName;
            return this;
        }

        public SimpleException build() {
            return SimpleException;
        }
    }



    public static SimpleExceptionBuilder builder(String exceptionName, IErrorCode errorCode, Throwable cause) {
        return new SimpleExceptionBuilder(exceptionName, errorCode, cause);
    }

    public static SimpleExceptionBuilder builder(String exceptionName, IErrorCode errorCode) {
        return new SimpleExceptionBuilder(exceptionName, errorCode,null);
    }

    public static boolean instanceOf(Exception e, String exceptionName) {
        if (Objects.isNull(e)) {
            return false;
        }

        if (!(e instanceof SimpleException)) {
            return false;
        }

        return Objects.equals(((SimpleException) e).getExceptionName(), exceptionName);
    }

    public static boolean equalErrorCode(Exception e, ErrorCode errorCode) {
        if (Objects.isNull(e)) {
            return false;
        }

        if (!(e instanceof SimpleException)) {
            return false;
        }

        return Objects.equals(((SimpleException) e).getErrorCode(), errorCode);
    }
}
