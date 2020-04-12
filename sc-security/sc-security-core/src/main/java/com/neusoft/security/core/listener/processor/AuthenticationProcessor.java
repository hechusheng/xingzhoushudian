package com.neusoft.security.core.listener.processor;

import org.springframework.security.authentication.event.AbstractAuthenticationEvent;

/**
 * <p>处理器根接口</p>
 * <p>创建日期：2018-04-20</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public interface AuthenticationProcessor<E extends AbstractAuthenticationEvent> {

    /**
     * 处理方法
     */
    void process(E event);

    /**
     * 是否由该处理器处理
     *
     * @return 结果
     */
    boolean should(E event);

}
