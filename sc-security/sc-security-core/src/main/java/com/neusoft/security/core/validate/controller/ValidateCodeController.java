package com.neusoft.security.core.validate.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.security.core.constant.SecurityConstants;
import com.neusoft.security.core.validate.ValidateCodeProcessorHolder;
import com.neusoft.security.core.validate.processor.ValidateCodeProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>验证码接口类</p>
 * <p>创建日期：2018-04-12</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@RestController
public class ValidateCodeController {

    private static final Logger logger = LoggerFactory.getLogger(ValidateCodeController.class);

    @Resource
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

    /**
     * 创建验证码，根据验证码类型不同，调用不同的 {@link ValidateCodeProcessor}接口实现
     *
     * @param request  the request
     * @param response the response
     * @param type     the type
     * @throws Exception the exception
     */
    @PostMapping(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/{type}")
    public void getCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) {
        try {
            validateCodeProcessorHolder.findValidateCodeProcessor(type).create(new ServletWebRequest(request, response));
        } catch (Exception e) {
            logger.error("验证码生成错误", e);
            throw new ScServerException("验证码生成错误");
        }
    }

    /**
     * Check code object.
     *
     * @param request  the request
     * @param response the response
     * @param type     the type
     * @return the object
     */
    @GetMapping(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/{type}")
    public Object checkCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) {
//        SecurityResult result = new SecurityResult(SecurityResult.SUCCESS_CODE, "校验成功", true);
//        try {
//            validateCodeProcessorHolder.findValidateCodeProcessor(type).check(new ServletWebRequest(request, response));
//        } catch (ValidateCodeException e) {
//            result = SecurityResult.error(e.getMessage(), false);
//        } catch (Exception e) {
//            log.error("getAccessToken={}", e.getMessage(), e);
//            result = SecurityResult.error("验证码错误", false);
//        }
        return null;
    }

}
