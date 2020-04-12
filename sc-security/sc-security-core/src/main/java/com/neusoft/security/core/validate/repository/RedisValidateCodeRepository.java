package com.neusoft.security.core.validate.repository;

import com.neusoft.security.core.validate.ValidateCodeType;
import com.neusoft.security.core.validate.entity.ValidateCode;
import com.neusoft.security.core.validate.exception.ValidateCodeException;
import com.neusoft.security.core.validate.processor.ValidateCodeHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


/**
 * <p></p>
 * <p>创建日期：2018-04-13</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType) {
        String key = buildKey(request, validateCodeType);
        redisTemplate.opsForValue().set(key, code, 3, TimeUnit.MINUTES);
    }

    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType) {
        Object value = redisTemplate.opsForValue().get(buildKey(request, validateCodeType));
        if (value == null) {
            return null;
        }
        return (ValidateCode) value;
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType codeType) {
        redisTemplate.delete(buildKey(request, codeType));
    }

    private String buildKey(ServletWebRequest request, ValidateCodeType type) {
        String deviceId = request.getParameter("deviceId") != null ? request.getParameter("deviceId") : ValidateCodeHolder.getDeviceIdHolder().get();
        if (StringUtils.isBlank(deviceId)) {
            throw new ValidateCodeException("请在请求头中携带deviceId参数");
        }
        return "code:" + type.toString().toLowerCase() + ":" + deviceId;
    }
}
