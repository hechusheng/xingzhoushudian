package com.neusoft.oauth.security;

import com.neusoft.core.restful.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>The class Pc access denied handler</p>
 * <p>创建日期：2018-04-17</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
public class ScAccessDeniedHandler implements AccessDeniedHandler {

    private static final Logger logger = LoggerFactory.getLogger(ScAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        logger.info("处理权限异常. e={}", accessDeniedException);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(AppResponse.noPermission("无访问权限").toJson());

    }
}
