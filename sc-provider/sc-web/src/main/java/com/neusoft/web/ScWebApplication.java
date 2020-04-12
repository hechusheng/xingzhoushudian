package com.neusoft.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>系统入口文件</p>
 * <p>创建日期：2017-12-07</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableResourceServer
@EnableFeignClients
@EnableSwagger2
public class ScWebApplication {


    public static void main(String[] args) {
        SpringApplication.run(ScWebApplication.class, args);
    }

}
