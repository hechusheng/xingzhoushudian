package com.neusoft.security.client.template.customizer;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterRestTemplateCustomizer;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Component
public class ScRibbonUserInfoRestTemplateCustomizer implements JwtAccessTokenConverterRestTemplateCustomizer {

    @Resource
    private RestTemplateCustomizer customizer;

    @Override
    public void customize(RestTemplate template) {
        customizer.customize(template);
    }

}
