package com.neusoft.admin.server;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * <p>系统入口文件</p>
 * <p>创建日期：2017-12-07</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
@EnableTurbine
@EnableHystrixDashboard
public class ScAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScAdminServerApplication.class, args);
    }

}
