package com.neusoft.service.api.helloservice.service;

import com.neusoft.service.api.helloservice.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * <p>测试服务调用接口</p>
 * <p>创建日期：2018-01-10</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@RequestMapping("/hello-service-remote")
public interface HelloServiceRemoteApi {

    /**
     * 传递RequestParam参数
     *
     * @param name 姓名
     * @return 字符串
     */
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    /**
     * 传递PathVariable参数
     *
     * @param id   id
     * @param name 姓名，使用RequestParam参数传递
     * @return user对象
     */
    @RequestMapping(value = "/hello3/{id}", method = RequestMethod.GET)
    User hello(@PathVariable("id") Long id, @RequestParam("name") String name);

    /**
     * 传递json对象参数
     *
     * @param user json对象
     * @return 字符串
     */
    @RequestMapping(value = "/hello4", method = RequestMethod.POST)
    String hello(@RequestBody User user);

}
