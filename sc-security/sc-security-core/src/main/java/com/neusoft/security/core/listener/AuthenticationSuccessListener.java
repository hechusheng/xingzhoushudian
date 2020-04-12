package com.neusoft.security.core.listener;

import com.neusoft.security.core.listener.processor.AbstractAuthenticationSuccessProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * <p>用户登录成功方法</p>
 * <p>创建日期：2018-04-20</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private AuthenticationProcessorHolder authenticationProcessorHolder;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        if (!CollectionUtils.isEmpty(authenticationProcessorHolder.getSuccessProcessors())) {
            for (Map.Entry<String, AbstractAuthenticationSuccessProcessor> item : authenticationProcessorHolder.getSuccessProcessors().entrySet()) {
                AbstractAuthenticationSuccessProcessor processor = item.getValue();
                if (processor.should(event)) {
                    processor.process(event);
                }
            }
        }
    }
}
