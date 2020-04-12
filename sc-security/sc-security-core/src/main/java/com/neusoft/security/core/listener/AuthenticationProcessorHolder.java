package com.neusoft.security.core.listener;

import com.neusoft.security.core.listener.processor.AbstractAuthenticationFailureProcessor;
import com.neusoft.security.core.listener.processor.AbstractAuthenticationSuccessProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <p>用户登录成功、失败处理器holder</p>
 * <p>创建日期：2018-04-20</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
public class AuthenticationProcessorHolder {

    @Autowired(required = false)
    private Map<String, AbstractAuthenticationFailureProcessor> failureProcessors;

    @Autowired(required = false)
    private Map<String, AbstractAuthenticationSuccessProcessor> successProcessors;

    public Map<String, AbstractAuthenticationFailureProcessor> getFailureProcessors() {
        return failureProcessors;
    }

    public void setFailureProcessors(Map<String, AbstractAuthenticationFailureProcessor> failureProcessors) {
        this.failureProcessors = failureProcessors;
    }

    public Map<String, AbstractAuthenticationSuccessProcessor> getSuccessProcessors() {
        return successProcessors;
    }

    public void setSuccessProcessors(Map<String, AbstractAuthenticationSuccessProcessor> successProcessors) {
        this.successProcessors = successProcessors;
    }
}
