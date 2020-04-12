package com.neusoft.security.core.token;

import com.neusoft.core.security.constant.SecurityConstants;
import com.neusoft.security.core.entity.SecurityUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>token转换器</p>
 * <p>创建日期：2018-01-03</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class ScTokenEnhancer extends JwtAccessTokenConverter implements Serializable {


    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken,
                                     OAuth2Authentication authentication) {
        Object principal = authentication.getPrincipal();
        OAuth2AccessToken enhancedToken = null;
        if (principal instanceof SecurityUser) {
            SecurityUser userDetails = (SecurityUser) authentication.getPrincipal();
            authentication.getUserAuthentication().getPrincipal();
            Map<String, Object> info = new HashMap<>(1);
            info.put(SecurityConstants.TOKEN_SEG_USER_ID, userDetails.getId());

            DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
            customAccessToken.setAdditionalInformation(info);
            enhancedToken = super.enhance(customAccessToken, authentication);
        } else {
            enhancedToken = super.enhance(new DefaultOAuth2AccessToken(accessToken), authentication);
        }

        return enhancedToken;
    }

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        OAuth2Authentication oAuth2Authentication = super.extractAuthentication(map);
        return oAuth2Authentication;
    }

    @Override
    public Map<String, Object> decode(String token) {
        return super.decode(token);
    }
}
