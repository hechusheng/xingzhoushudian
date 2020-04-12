package com.neusoft.security.core.listener.processor;

import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;

/**
 * <p>登录后失败处理器</p>
 * <p>创建日期：2018-04-20</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public abstract class AbstractAuthenticationFailureProcessor<E extends AbstractAuthenticationFailureEvent> implements AuthenticationProcessor<E> {

    @Override
    public boolean should(E event) {
        return event instanceof AbstractAuthenticationFailureEvent;
    }

}
