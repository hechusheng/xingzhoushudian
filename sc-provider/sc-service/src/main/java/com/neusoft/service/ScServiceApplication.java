package com.neusoft.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * <p>系统入口文件</p>
 * <p>创建日期：2017-12-07</p>
 * 
 * @author 杨洲 yangzhou@neusoft.com
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
public class ScServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScServiceApplication.class, args);
    }

}
