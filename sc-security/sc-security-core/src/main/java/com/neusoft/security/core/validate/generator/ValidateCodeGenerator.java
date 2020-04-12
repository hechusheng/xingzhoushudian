package com.neusoft.security.core.validate.generator;

import com.neusoft.security.core.validate.entity.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * <p>校验码生成器</p>
 * <p>创建日期：2018-04-13</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public interface ValidateCodeGenerator {

    /**
     * 生成校验码
     *
     * @param request the request
     * @return validate code
     */
    ValidateCode generate(ServletWebRequest request);
}
