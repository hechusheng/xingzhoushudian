package com.neusoft.security.core.listener;

import com.neusoft.security.core.listener.processor.AbstractAuthenticationFailureProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * <p>登录失败监听器</p>
 * <p>创建日期：2018-04-20</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
public class AuthenticationFailureListener implements ApplicationListener<AbstractAuthenticationFailureEvent> {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFailureListener.class);

    @Autowired
    private AuthenticationProcessorHolder authenticationProcessorHolder;

    @Override
    public void onApplicationEvent(AbstractAuthenticationFailureEvent event) {
        if (!CollectionUtils.isEmpty(authenticationProcessorHolder.getFailureProcessors())) {
            for (Map.Entry<String, AbstractAuthenticationFailureProcessor> item : authenticationProcessorHolder.getFailureProcessors().entrySet()) {
                AbstractAuthenticationFailureProcessor processor = item.getValue();
                if (processor.should(event)) {
                    processor.process(event);
                }
            }
        }
    }

}
