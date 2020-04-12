package com.neusoft.security.core.validate.repository;

import com.neusoft.security.core.validate.ValidateCodeType;
import com.neusoft.security.core.validate.entity.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * <p>校验码存取器</p>
 * <p>创建日期：2018-04-13</p>
 * 
 * @author 杨洲 yangzhou@neusoft.com
 */
public interface ValidateCodeRepository {

	/**
	 * 保存验证码
	 *
	 * @param request          the request
	 * @param code             the code
	 * @param validateCodeType the validate code type
	 */
	void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType);

	/**
	 * 获取验证码
	 *
	 * @param request          the request
	 * @param validateCodeType the validate code type
	 *
	 * @return validate code
	 */
	ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType);

	/**
	 * 移除验证码
	 *
	 * @param request  the request
	 * @param codeType the code type
	 */
	void remove(ServletWebRequest request, ValidateCodeType codeType);

}
