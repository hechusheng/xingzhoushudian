package com.neusoft.oauth.entity;

/**
 * <p>用户信息</p>
 * <p>创建日期：2017-12-27</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class SysUser {

    private String id;

    private String account;

    private String name;

    private String password;

    private String clientId;

    private String locked;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
