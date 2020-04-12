package com.neusoft.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

/**
 * <p>项目启动类</p>
 * <p>创建日期：2018-04-26</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
@EnableSwagger2
@EnableTransactionManagement
@MapperScan("com.neusoft.project")
@EnableRedisHttpSession
public class ScProjectApplication {

    @Resource
    private StringRedisTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(ScProjectApplication.class, args);
    }

}
