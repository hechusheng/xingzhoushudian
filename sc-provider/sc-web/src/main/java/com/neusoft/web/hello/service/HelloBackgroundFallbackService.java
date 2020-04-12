package com.neusoft.web.hello.service;

import com.neusoft.service.api.helloservice.entity.User;

/**
 * <p>测试服务熔断回调服务类</p>
 * <p>创建日期：2018-01-10</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class HelloBackgroundFallbackService implements HelloBackgroundService {

    @Override
    public String hello(String name) {
        return null;
    }

    @Override
    public User hello(Long id, String name) {
        return null;
    }

    @Override
    public String hello(User user) {
        return null;
    }
}
