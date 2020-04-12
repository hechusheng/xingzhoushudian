package com.neusoft.service.api.helloservice.entity;

import java.io.Serializable;

/**
 * <p>测试参数传递-角色</p>
 * <p>创建日期：2018-01-10</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class Role implements Serializable {

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }
}
