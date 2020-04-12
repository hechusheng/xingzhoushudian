package com.neusoft.security.core.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;


@Component
public class ActuatorSecurityConfigure {

    public static ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests) {
        return authorizeRequests.mvcMatchers("/info", "/autoconfig", "/health", "/beans", "/configprops", "/env", "/mappings", "/metrics", "/dump", "/trace").permitAll();
    }

}
