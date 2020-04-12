package com.neusoft.webstatic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>系统启动类</p>
 * <p>创建日期：2018-03-01</p>
 * 
 * @author 杨洲 yangzhou@neusoft.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ScWebStaticApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScWebStaticApplication.class, args);
    }

}
