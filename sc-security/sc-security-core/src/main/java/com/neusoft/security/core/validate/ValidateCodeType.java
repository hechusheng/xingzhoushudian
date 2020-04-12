package com.neusoft.security.core.validate;


import com.neusoft.security.core.constant.SecurityConstants;

/**
 * 校验码类型
 *
 * @author paascloud.net @gmail.com
 */
public enum ValidateCodeType {

    /**
     * 图片验证码
     */
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    /**
     * 校验时从请求中获取的参数的名字
     *
     * @return param name on validate
     */
    public abstract String getParamNameOnValidate();

}
