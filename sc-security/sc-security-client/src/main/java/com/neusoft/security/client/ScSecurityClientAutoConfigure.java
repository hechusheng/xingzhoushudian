package com.neusoft.security.client;

import com.neusoft.security.client.authorize.ScAuthorizeConfigManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration()
@ComponentScan(basePackages = "com.neusoft.security.client")
public class ScSecurityClientAutoConfigure {

    @Bean
    public ScAuthorizeConfigManager scAuthorizeConfigManager() {
        return new ScAuthorizeConfigManager();
    }

}
