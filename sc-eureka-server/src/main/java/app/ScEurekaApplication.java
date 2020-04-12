package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>系统入口文件</p>
 * <p>创建日期：2017-12-07</p>
 * 
 * @author 杨洲 yangzhou@neusoft.com
 */
@SpringBootApplication
@EnableEurekaServer
public class ScEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScEurekaApplication.class, args);
    }

}
