package com.neusoft.security.client.authorize;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;


/**
 * <p>监控权限配置</p>
 * <p>创建日期：2018-04-24</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
@Order(Integer.MIN_VALUE)
public class ActuatorAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config
                .antMatchers("/env", "/health", "/metrics", "/trace", "/dump", "/jolokia", "/info", "/configprops", "/activiti", "/logfile", "/refresh", "/flyway", "/liquibase", "/loggers").permitAll();
        return false;
    }

}
