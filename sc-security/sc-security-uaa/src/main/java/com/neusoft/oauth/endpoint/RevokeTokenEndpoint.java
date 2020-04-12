package com.neusoft.oauth.endpoint;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.core.restful.AppResponseStatus;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>token销毁控制器</p>
 * <p>创建日期：2018-01-01</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@RestController
public class RevokeTokenEndpoint {

//    @Resource
//    private RedisTokenStore redisTokenStore;
//
//    @RequestMapping(method = RequestMethod.GET, value = "/oauth/revokeToken")
//    @ResponseBody
//    public AppResponse revokeToken(@Param("access_token") String accessToken) {
//        if (StringUtils.isNotBlank(accessToken)) {
//            redisTokenStore.removeAccessToken(accessToken);
//            return AppResponse.builder().code(AppResponseStatus.SUCCESS).msg("注销成功").build();
//        }
//        return AppResponse.builder().code(AppResponseStatus.ERROR).msg("access_token is not empty").build();
//    }
}
