package com.neusoft.security.core.validate.processor;

import com.neusoft.security.core.validate.ValidateCodeType;
import com.neusoft.security.core.validate.entity.ValidateCode;
import com.neusoft.security.core.validate.exception.ValidateCodeException;
import com.neusoft.security.core.validate.generator.ValidateCodeGenerator;
import com.neusoft.security.core.validate.repository.ValidateCodeRepository;
import com.neusoft.util.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * <p>抽象的验证码处理器</p>
 * <p>创建日期：2018-04-13</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    /**
     * 注入接口中对应的 {@link ValidateCodeGenerator} 接口的实现。
     */
    private final ValidateCodeGenerator validateCodeGenerators;

    private final ValidateCodeRepository validateCodeRepository;

    /**
     * Instantiates a new Abstract validate code processor.
     *
     * @param validateCodeGenerators the validate code generators
     * @param validateCodeRepository the validate code repository
     */
    @Autowired
    public AbstractValidateCodeProcessor(ValidateCodeGenerator validateCodeGenerators, ValidateCodeRepository validateCodeRepository) {
        this.validateCodeGenerators = validateCodeGenerators;
        this.validateCodeRepository = validateCodeRepository;
    }

    /**
     * Create.
     *
     * @param request the request
     * @throws Exception the exception
     */
    @Override
    public void create(ServletWebRequest request) throws Exception {

        try {
            C validateCode = generate(request);

            String deviceId = UUIDUtils.getUUID();
            //设置deviceId
            ValidateCodeHolder.getDeviceIdHolder().set(deviceId);

            save(request, validateCode);
            send(request, validateCode);
        } finally {
            ValidateCodeHolder.getDeviceIdHolder().remove();
        }
    }

    /**
     * 生成校验码
     */
    @SuppressWarnings("unchecked")
    private C generate(ServletWebRequest request) {
        return (C) validateCodeGenerators.generate(request);
    }

    /**
     * 保存校验码
     */
    private void save(ServletWebRequest request, C validateCode) {
        ValidateCode code = new ValidateCode(validateCode.getCode(), validateCode.getExpireTime());
        validateCodeRepository.save(request, code, getValidateCodeType());
    }

    /**
     * 发送校验码，由子类实现
     *
     * @param request      the request
     * @param validateCode the validate code
     * @throws Exception the exception
     */
    protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;

    /**
     * 根据请求的url获取校验码的类型
     */
    private ValidateCodeType getValidateCodeType() {
        String type = StringUtils.substringBefore(getClass().getSimpleName(), "ValidateCodeProcessor");
        return ValidateCodeType.valueOf(type.toUpperCase());
    }

    @Override
    public void validate(ServletWebRequest request) {

        ValidateCodeType codeType = getValidateCodeType();
        this.check(request);
        validateCodeRepository.remove(request, codeType);

    }

    /**
     * Check.
     *
     * @param request the request
     */
    @SuppressWarnings("unchecked")
    @Override
    public void check(ServletWebRequest request) {
        ValidateCodeType codeType = getValidateCodeType();

        C codeInSession = (C) validateCodeRepository.get(request, codeType);

        String codeInRequest;
        try {
            codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), codeType.getParamNameOnValidate());
        } catch (ServletRequestBindingException e) {
            throw new ValidateCodeException("获取验证码的值失败");
        }

        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException(codeType + "验证码的值不能为空");
        }

        if (codeInSession == null || codeInSession.isExpired()) {
            validateCodeRepository.remove(request, codeType);
            throw new ValidateCodeException(codeType + "验证码已过期");
        }

        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest.toLowerCase())) {
            throw new ValidateCodeException(codeType + "验证码不匹配");
        }
    }


}
