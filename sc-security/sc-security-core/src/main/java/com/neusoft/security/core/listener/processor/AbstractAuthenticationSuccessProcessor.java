package com.neusoft.security.core.listener.processor;

import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

/**
 * <p>登录成功后处理器接口</p>
 * <p>创建日期：2018-04-20</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public abstract class AbstractAuthenticationSuccessProcessor<E extends AuthenticationSuccessEvent> implements AuthenticationProcessor<E> {

    @Override
    public boolean should(E event) {
        return event instanceof AuthenticationSuccessEvent;
    }
}
