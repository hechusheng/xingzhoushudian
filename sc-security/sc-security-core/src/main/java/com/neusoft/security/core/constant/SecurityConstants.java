package com.neusoft.security.core.constant;

public interface SecurityConstants {

    /**
     * 默认的用户名密码登录请求处理url
     */
    String DEFAULT_SIGN_IN_PROCESSING_URL_FORM = "/auth/form";

    String DEFAULT_UNAUTHENTICATION_URL = "/auth/require";

    /**
     * 默认的处理验证码的url前缀
     */
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/auth/code";

    /**
     * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";

    String MAX_FAIL_TIMES = "maxFailTimes";

}