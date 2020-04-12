package com.neusoft.job;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * <p>程序入口文件</p>
 * <p>创建日期：2018-02-09</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
@MapperScan("com.neusoft.job")
public class ScJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScJobApplication.class, args);
    }
}
