package com.neusoft.security.client.oauth;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.core.restful.AppResponseStatus;
import com.neusoft.util.JsonUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * <p>异常信息展示转换服务</p>
 * <p>创建日期：2018-02-28</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
public class ScWebResponseExceptionTranslator extends DefaultWebResponseExceptionTranslator {

    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
        ResponseEntity responseEntity = super.translate(e);
        HttpHeaders headers = new HttpHeaders();
        headers.setAll(responseEntity.getHeaders().toSingleValueMap());
        //如果是未授权
        if (HttpStatus.UNAUTHORIZED.value() == responseEntity.getStatusCode().value()) {
            AppResponse appResponse = AppResponse.builder().code(AppResponseStatus.NO_PERMISSION).msg("Invalid Access Token").build();
            return new ResponseEntity(JsonUtils.toJson(appResponse), headers, HttpStatus.OK);
        }
        //如果授权服务异常
        if (HttpStatus.BAD_REQUEST.value() == responseEntity.getStatusCode().value()) {
            AppResponse appResponse = AppResponse.builder().code(AppResponseStatus.NO_PERMISSION).msg(e.getMessage()).build();
            return new ResponseEntity(JsonUtils.toJson(appResponse), headers, HttpStatus.OK);
        } else {
            AppResponse appResponse = AppResponse.builder().code(AppResponseStatus.NO_PERMISSION).msg(e.getMessage()).build();
            return new ResponseEntity(JsonUtils.toJson(appResponse), headers, responseEntity.getStatusCode());
        }
    }

}
