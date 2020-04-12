package com.neusoft.web.hello.controller;

import com.neusoft.core.restful.AppResponse;
//import com.neusoft.core.restful.AppResponseStatus;
//import com.neusoft.service.api.helloservice.entity.Role;
//import com.neusoft.service.api.helloservice.entity.User;
//import com.neusoft.web.hello.service.HelloBackgroundService;
import com.neusoft.core.restful.AppResponseStatus;
import com.neusoft.service.api.helloservice.entity.Role;
import com.neusoft.service.api.helloservice.entity.User;
import com.neusoft.web.hello.service.HelloBackgroundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>测试服务间参数传递的控制器</p>
 * <p>创建日期：2018-01-10</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloBackgroundService helloBackgroundService;

    @GetMapping("test")
    public AppResponse test() {
        return AppResponse.success("调用成功");
    }

    /**
     * 测试服务间参数调用
     *
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public AppResponse hello() {
        Map<String, Object> ret = new HashMap<>(3);

        String s1 = helloBackgroundService.hello("张三");
        ret.put("RequestParam方式", s1);

        User s3 = helloBackgroundService.hello(10L, "张三");
        ret.put("PathVariable方式", s3);

        User user1 = new User("张三", 50);
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("admin"));
        roles.add(new Role("user"));
        user1.setRoles(roles);

        String s4 = helloBackgroundService.hello(user1);
        ret.put("json方式复杂结构", s4);

        return AppResponse.builder().code(AppResponseStatus.SUCCESS).msg("接口调用成功").data(ret).build();
    }

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    public AppResponse hello1() {
        return AppResponse.builder().code(AppResponseStatus.SUCCESS).msg("接口调用成功").data("hello").build();
    }


    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public AppResponse upload(@RequestParam("file") MultipartFile file, String id) {
        System.out.println(id);
        System.out.println(file.getOriginalFilename());
        return AppResponse.builder().code(AppResponseStatus.SUCCESS).build();
    }

}
