package com.neusoft.security.core.properties;

/**
 * <p>浏览器client oauth信息</p>
 * <p>创建日期：2018-04-12</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class BrowserProperties {

    private String clientId;

    private String clientSecret;

    private String grantType;

    private String scope;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
