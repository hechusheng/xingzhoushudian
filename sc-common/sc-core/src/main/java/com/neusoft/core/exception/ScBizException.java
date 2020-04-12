package com.neusoft.core.exception;

/**
 * <p>服务端业务异常</p>
 * <p>创建日期：2018-02-28</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class ScBizException extends ScRuntimeException {

    private String code;

    public ScBizException() {
    }

    public ScBizException(String code) {
        this.code = code;
    }

    public ScBizException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScBizException(Throwable cause) {
        super(cause);
    }

    public ScBizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ScBizException(String message, String code) {
        super(message);
        this.code = code;
    }

    public ScBizException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public ScBizException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public ScBizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
