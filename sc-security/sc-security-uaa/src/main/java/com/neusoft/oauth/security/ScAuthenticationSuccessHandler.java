package com.neusoft.oauth.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.oauth.service.UaaUserService;
import com.neusoft.security.core.entity.SecurityUser;
import com.neusoft.security.core.properties.BrowserProperties;
import com.neusoft.security.core.properties.SecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * <p>APP环境下认证成功处理器</p>
 * <p>创建日期：2018-04-12</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
public class ScAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(ScAuthenticationSuccessHandler.class);

    @Resource
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Resource
    private ClientDetailsService clientDetailsService;

    @Autowired
    private UaaUserService uacUserService;

    @Resource
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        BrowserProperties browserProperties = securityProperties.getOauth2().getBrowser();

        logger.info("登录成功");

        SecurityUser principal = (SecurityUser) authentication.getPrincipal();

        String clientId = browserProperties.getClientId();
        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(browserProperties.getClientId());

        if (clientDetails == null) {
            throw new UnapprovedClientAuthenticationException("clientId对应的配置信息不存在:" + clientId);
        } else if (!StringUtils.equals(clientDetails.getClientSecret(), browserProperties.getClientSecret())) {
            throw new UnapprovedClientAuthenticationException("clientSecret不匹配:" + clientId);
        }

        TokenRequest tokenRequest = new TokenRequest(new HashMap<>(1), clientId, clientDetails.getScope(), browserProperties.getGrantType());

        OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);

        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);

        //生成token
        OAuth2AccessToken token = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);

        uacUserService.handlerLoginData(token, principal, request);

        logger.info("用户【 {} 】记录登录日志", principal.getUsername());

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write((objectMapper.writeValueAsString(AppResponse.success("login success", token))));
    }

}
