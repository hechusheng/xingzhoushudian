package com.neusoft.oauth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>用户控制器</p>
 * <p>创建日期：2018-01-01</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@RestController
public class UserController {


    @GetMapping("/user")
    public Object user(Authentication authentication) {
        return authentication.getPrincipal();
    }

}
