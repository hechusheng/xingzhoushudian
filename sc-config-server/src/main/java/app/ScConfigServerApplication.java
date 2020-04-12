package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * <p>系统入口文件</p>
 * <p>创建日期：2017-12-07</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ScConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScConfigServerApplication.class, args);
    }

}
