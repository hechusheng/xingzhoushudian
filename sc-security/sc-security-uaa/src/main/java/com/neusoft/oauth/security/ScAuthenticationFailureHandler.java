package com.neusoft.oauth.security;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.core.maxfail.MaxFailException;
import com.neusoft.security.core.validate.exception.ValidateCodeException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>APP环境下认证失败处理器</p>
 * <p>创建日期：2018-04-13</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
public class ScAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        AppResponse appResponse = null;
        if (exception instanceof MaxFailException) {
            appResponse = AppResponse.bizError("登录错误已达最大次数，请" + ((MaxFailException) exception).getTimes() + "秒后重试");
        }
        if (exception instanceof ValidateCodeException) {
            appResponse = AppResponse.invalidImage("请输入正确的验证码");
        }
        if (exception instanceof BadCredentialsException) {
            appResponse = AppResponse.notFound("用户名或密码错误");
        }
        if (appResponse == null) {
            appResponse = AppResponse.bizError("登录错误");
        }
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(appResponse.toJson());
    }
}
