package com.neusoft.security.core.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * <p>自定义用户信息</p>
 * <p>创建日期：2018-01-03</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class SecurityUser extends User {

    /**
     * 用户主键
     */
    private String id;

    private String name;


    public SecurityUser(String id, String username, String name, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
