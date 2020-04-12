package com.neusoft.security.core.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p></p>
 * <p>创建日期：2018-04-12</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@ConfigurationProperties(prefix = "sc.security")
public class SecurityProperties {


    private LoginProperties login = new LoginProperties();

    /**
     * 验证码配置
     */
    private ValidateCodeProperties validateCode = new ValidateCodeProperties();

    private final Oauth2Properties oauth2 = new Oauth2Properties();


    public LoginProperties getLogin() {
        return login;
    }

    public void setLogin(LoginProperties login) {
        this.login = login;
    }

    public ValidateCodeProperties getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(ValidateCodeProperties validateCode) {
        this.validateCode = validateCode;
    }

    public Oauth2Properties getOauth2() {
        return oauth2;
    }
}
