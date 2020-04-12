package com.neusoft.core.exception;

/**
 * <p>客户端参数异常</p>
 * <p>创建日期：2018-02-28</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class ScParameterException extends ScClientException {

    public ScParameterException() {
    }

    public ScParameterException(String message) {
        super(message);
    }

    public ScParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScParameterException(Throwable cause) {
        super(cause);
    }

    public ScParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
