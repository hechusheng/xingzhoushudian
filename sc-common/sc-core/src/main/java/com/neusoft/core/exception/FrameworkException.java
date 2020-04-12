package com.neusoft.core.exception;

/**
 * <p>系统自定义异常类</p>
 * <p>创建日期：2018-01-10</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class FrameworkException extends RuntimeException {

    public FrameworkException() {
    }

    public FrameworkException(String message) {
        super(message);
    }

    public FrameworkException(String message, Throwable cause) {
        super(message, cause);
    }

    public FrameworkException(Throwable cause) {
        super(cause);
    }

    public FrameworkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
