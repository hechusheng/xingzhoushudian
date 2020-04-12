package com.neusoft.core.exception;

import com.neusoft.core.restful.AppResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * <p></p>
 * <p>创建日期：2018-03-01</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@ControllerAdvice
public class ScExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ScExceptionHandle.class);

    @ExceptionHandler(value = ScServerException.class)
    @ResponseBody
    public AppResponse exception(ScServerException e, WebRequest request) {
        return AppResponse.serverError(e.getMessage());
    }

    @ExceptionHandler(value = ScClientException.class)
    @ResponseBody
    public AppResponse exception(ScClientException e) {
        return AppResponse.clientError(e.getMessage());
    }

    /**
     * validate参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public AppResponse exception(ConstraintViolationException e) {
        String msg = null;
        for (ConstraintViolation item : e.getConstraintViolations()) {
            msg = item.getMessage();
        }
        return AppResponse.paramError(msg);
    }

    /**
     * validate参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public AppResponse exception(BindException e) {
        String msg = null;
        for (ObjectError item : e.getAllErrors()) {
            msg = item.getDefaultMessage();
        }
        return AppResponse.paramError(msg);
    }


    @ExceptionHandler(value = ScParameterException.class)
    @ResponseBody
    public AppResponse exception(ScParameterException e) {
        return AppResponse.paramError(e.getMessage());
    }

    @ExceptionHandler(value = ScBizException.class)
    @ResponseBody
    public AppResponse exception(ScBizException e) {
        return AppResponse.bizError(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public AppResponse exception(Exception e) {
        logger.error("系统发生未知异常", e);
        return AppResponse.unknownError(StringUtils.isNotBlank(e.getMessage()) ? e.getMessage() : "系统发生未知异常");
    }


}
