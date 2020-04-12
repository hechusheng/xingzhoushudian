package com.neusoft.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>网关拦截器</p>
 * <p>创建日期：2018-01-17</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Configuration
public class AuthFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object detail = authentication.getDetails();
        if (detail instanceof OAuth2AuthenticationDetails) {
            OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) detail;
            String token = oAuth2AuthenticationDetails.getTokenValue();
//            oAuth2AuthenticationDetails.getDecodedDetails()
        }
        requestContext.addZuulRequestHeader("X-AUTH-ID", authentication.getPrincipal().toString());
        return null;
    }

}
