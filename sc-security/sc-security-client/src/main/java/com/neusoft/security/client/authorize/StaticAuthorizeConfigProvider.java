package com.neusoft.security.client.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * <p>静态资源权限过滤器</p>
 * <p>创建日期：2018-04-24</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
public class StaticAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config
                .antMatchers("/**/favicon.ico", "/js/**", "/css/**", "/img/**", "/html/**", "/error/**").permitAll()
                .antMatchers("/druid/**", "/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs").permitAll();
        return false;
    }

}
