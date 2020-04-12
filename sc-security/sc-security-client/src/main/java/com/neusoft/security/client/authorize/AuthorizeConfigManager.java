package com.neusoft.security.client.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * <p> * 授权信息管理器,用于收集系统中所有 AuthorizeConfigProvider 并加载其配置</p>
 * <p>创建日期：2018-04-23</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public interface AuthorizeConfigManager {

    /**
     * Config.
     *
     * @param config the config
     */
    void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);

}
