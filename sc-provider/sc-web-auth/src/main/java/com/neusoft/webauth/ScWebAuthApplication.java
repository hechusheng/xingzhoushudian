package com.neusoft.webauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>系统启动类</p>
 * <p>创建日期：2018-01-05</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
@EnableSwagger2
@EnableTransactionManagement
@MapperScan("com.neusoft.webauth")
public class ScWebAuthApplication {


    public static void main(String[] args) {
        SpringApplication.run(ScWebAuthApplication.class, args);
    }


}
