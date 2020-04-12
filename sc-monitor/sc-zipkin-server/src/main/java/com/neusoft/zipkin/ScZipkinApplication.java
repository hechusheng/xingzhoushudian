package com.neusoft.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * <p>程序启动类</p>
 * <p>创建日期：2018-03-01</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@SpringBootApplication
@EnableZipkinServer
public class ScZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScZipkinApplication.class, args);
    }

}
