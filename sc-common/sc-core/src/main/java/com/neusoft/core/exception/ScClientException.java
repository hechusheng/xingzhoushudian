package com.neusoft.core.exception;

/**
 * <p>客户端异常</p>
 * <p>创建日期：2018-02-28</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class ScClientException extends ScRuntimeException {

    public ScClientException() {
    }

    public ScClientException(String message) {
        super(message);
    }

    public ScClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScClientException(Throwable cause) {
        super(cause);
    }

    public ScClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
