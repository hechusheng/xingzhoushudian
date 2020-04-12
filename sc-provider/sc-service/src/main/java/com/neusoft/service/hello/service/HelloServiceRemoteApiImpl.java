package com.neusoft.service.hello.service;

import com.neusoft.service.api.helloservice.entity.User;
import com.neusoft.service.api.helloservice.service.HelloServiceRemoteApi;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>测试服务提供类</p>
 * <p>创建日期：2018-01-10</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@RestController
public class HelloServiceRemoteApiImpl implements HelloServiceRemoteApi {


    /**
     * 接收@RequestParam参数
     *
     * @param name 姓名
     * @return 字符串
     */
    @Override
    public String hello(String name) {
        return "hello " + name;
    }

    /**
     * 接收@PathVariable参数
     *
     * @param id   id
     * @param name 姓名，使用@RequestParam传递
     * @return user对象
     */
    @Override
    public User hello(@PathVariable("id") Long id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    /**
     * 接收json参数
     *
     * @param user json对象
     * @return 字符串
     */
    @Override
    public String hello(@RequestBody User user) {
        if (user == null) {
            return "未知";
        }
        return user.toString();
    }

}
