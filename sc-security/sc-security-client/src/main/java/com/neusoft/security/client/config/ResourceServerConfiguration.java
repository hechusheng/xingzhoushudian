package com.neusoft.security.client.config;

import com.neusoft.security.client.authorize.ScAuthorizeConfigManager;
import com.neusoft.security.client.oauth.ScWebResponseExceptionTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;

/**
 * <p>项目安全配置</p>
 * <p>创建日期：2018-04-26</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {


    @Autowired
    private ScAuthorizeConfigManager scAuthorizeConfigManager;


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        OAuth2AuthenticationEntryPoint authenticationEntryPoint = new OAuth2AuthenticationEntryPoint();
        authenticationEntryPoint.setExceptionTranslator(new ScWebResponseExceptionTranslator());
        resources.authenticationEntryPoint(authenticationEntryPoint);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        scAuthorizeConfigManager.config(http.authorizeRequests());

        http.authorizeRequests()
                .anyRequest().authenticated();
    }


}
