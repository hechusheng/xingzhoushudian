package com.neusoft.core.exception;

/**
 * <p>框架基类异常</p>
 * <p>创建日期：2018-02-28</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class ScRuntimeException extends RuntimeException {

    public ScRuntimeException() {
    }

    public ScRuntimeException(String message) {
        super(message);
    }

    public ScRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScRuntimeException(Throwable cause) {
        super(cause);
    }

    public ScRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
