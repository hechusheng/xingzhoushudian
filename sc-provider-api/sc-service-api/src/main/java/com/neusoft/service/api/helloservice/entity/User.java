package com.neusoft.service.api.helloservice.entity;

import java.io.Serializable;
import java.util.List;

/**
 * <p>测试参数传递-用户实体</p>
 * <p>创建日期：2018-01-10</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class User implements Serializable {

    private static final long serialVersionUID = -7233238826463139634L;

    private Long id;

    private String name;

    private Integer age;

    List<Role> roles;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", roles=" + roles +
                '}';
    }
}