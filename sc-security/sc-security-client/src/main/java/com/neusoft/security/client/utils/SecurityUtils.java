package com.neusoft.security.client.utils;

import com.neusoft.core.property.ScCloudProperties;
import com.neusoft.core.security.constant.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.common.util.JsonParser;
import org.springframework.security.oauth2.common.util.JsonParserFactory;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <p>权限工具类</p>
 * <p>创建日期：2018-01-01</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
public class SecurityUtils {

    private static JsonParser objectMapper = JsonParserFactory.create();


    private static ScCloudProperties scCloudProperties;

    /**
     * 获取登录用户id
     *
     * @return 用户id
     */
    public static String getCurrentUserId() {
        if (scCloudProperties.getDev()) {
            return "测试用户";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object details = authentication.getDetails();
        if (details instanceof OAuth2AuthenticationDetails) {
            OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) details;
            String token = oAuth2AuthenticationDetails.getTokenValue();
            Map<String, Object> map = decode(token);
            if (map.containsKey(SecurityConstants.TOKEN_SEG_USER_ID)) {
                return map.get(SecurityConstants.TOKEN_SEG_USER_ID).toString();
            }
        }
        throw new RuntimeException("not a login user");
    }

    /**
     * 获取当前用户名称
     *
     * @return 用户名称
     */
    public static String getCurrentUserUsername() {
        if (scCloudProperties.getDev()) {
            return "测试用户";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getPrincipal().toString();
        }

        return currentUserName;
    }

    private static Map<String, Object> decode(String token) {
        Jwt jwt = JwtHelper.decode(token);
        String content = jwt.getClaims();
        return objectMapper.parseMap(content);
    }

    @Autowired
    public void setScCloudProperties(ScCloudProperties scCloudProperties) {
        SecurityUtils.scCloudProperties = scCloudProperties;
    }
}
