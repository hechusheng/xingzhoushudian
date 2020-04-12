package com.neusoft.security.client.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;

/**
 * <p>feign的oauth2权限配置</p>
 * <p>创建日期：2018-04-26</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Configuration
public class Oauth2FeignConfig {

    @Bean
    @ConditionalOnClass(FeignClientsConfiguration.class)
    public OAuth2FeignRequestInterceptor oAuth2FeignRequestInterceptor(OAuth2RestTemplate oAuth2RestTemplate, AccessTokenProviderChain accessTokenProviderChain) {
        OAuth2FeignRequestInterceptor oAuth2FeignRequestInterceptor = new OAuth2FeignRequestInterceptor(oAuth2RestTemplate.getOAuth2ClientContext(), oAuth2RestTemplate.getResource());
        oAuth2FeignRequestInterceptor.setAccessTokenProvider(accessTokenProviderChain);
        return oAuth2FeignRequestInterceptor;
    }
}
