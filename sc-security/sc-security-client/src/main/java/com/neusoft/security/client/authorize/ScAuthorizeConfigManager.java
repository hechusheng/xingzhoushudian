package com.neusoft.security.client.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class ScAuthorizeConfigManager implements AuthorizeConfigManager {

    @Autowired(required = false)
    private List<AuthorizeConfigProvider> authorizeConfigProviders;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        if (!CollectionUtils.isEmpty(authorizeConfigProviders)) {
            for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {
                authorizeConfigProvider.config(config);
            }
        }
    }

}
