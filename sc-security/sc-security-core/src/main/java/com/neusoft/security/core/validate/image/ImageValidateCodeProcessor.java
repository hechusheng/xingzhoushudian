package com.neusoft.security.core.validate.image;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.core.validate.processor.AbstractValidateCodeProcessor;
import com.neusoft.security.core.validate.processor.ValidateCodeHolder;
import com.neusoft.security.core.validate.repository.ValidateCodeRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

/**
 * <p>图片验证码处理器</p>
 * <p>创建日期：2018-04-16</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
public class ImageValidateCodeProcessor extends AbstractValidateCodeProcessor<ImageValidateCode> {

    /**
     * Instantiates a new Abstract validate code processor.
     *
     * @param validateCodeGenerators the validate code generators
     * @param validateCodeRepository the validate code repository
     */
    public ImageValidateCodeProcessor(ImageCodeGenerator validateCodeGenerators, ValidateCodeRepository validateCodeRepository) {
        super(validateCodeGenerators, validateCodeRepository);
    }

    /**
     * 发送图形验证码，将其写到响应中
     *
     * @param request      the request
     * @param validateCode the image code
     * @throws Exception the exception
     */
    @Override
    protected void send(ServletWebRequest request, ImageValidateCode validateCode) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(validateCode.getImage(), "JPEG", bos);
        String deviceId = ValidateCodeHolder.getDeviceIdHolder().get();
        ImageResponseBody responseBody = new ImageResponseBody(deviceId, Base64.getEncoder().encodeToString(bos.toByteArray()));

        AppResponse appResponse = AppResponse.success("图片验证码生成成功", responseBody);

        HttpServletResponse response = request.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(appResponse.toJson());
    }

 }
