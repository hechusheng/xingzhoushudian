package com.neusoft.security.client.config;

import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenProvider;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import java.util.Arrays;
import java.util.Collections;

/**
 * <p>ribbon的oauth2的权限配置</p>
 * <p>创建日期：2018-04-26</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Configuration
public class Oauth2RestTemplateConfig {


    @Bean
    public AccessTokenProviderChain accessTokenProviderChain(LoadBalancerInterceptor loadBalancerInterceptor) {
        ClientCredentialsAccessTokenProvider clientCredentialsAccessTokenProvider = new ClientCredentialsAccessTokenProvider();
        clientCredentialsAccessTokenProvider.setInterceptors(Collections.singletonList(loadBalancerInterceptor));
        return new AccessTokenProviderChain(Arrays.<AccessTokenProvider>asList(clientCredentialsAccessTokenProvider));
    }

    @Bean
    BaseOAuth2ProtectedResourceDetails baseOAuth2ProtectedResourceDetails(OAuth2ClientProperties oAuth2ClientProperties, ResourceServerProperties resourceServerProperties) {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setClientId(oAuth2ClientProperties.getClientId());
        details.setClientSecret(oAuth2ClientProperties.getClientSecret());
        details.setAccessTokenUri(resourceServerProperties.getTokenInfoUri());
        return details;
    }

    @Bean
    @Primary
    public OAuth2RestTemplate oAuth2RestTemplate(RestTemplateCustomizer customizer, BaseOAuth2ProtectedResourceDetails baseOAuth2ProtectedResourceDetails,
                                                 AccessTokenProviderChain accessTokenProviderChain) {

        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(baseOAuth2ProtectedResourceDetails);

        oAuth2RestTemplate.setAccessTokenProvider(accessTokenProviderChain);

        customizer.customize(oAuth2RestTemplate);

        return oAuth2RestTemplate;
    }

}
