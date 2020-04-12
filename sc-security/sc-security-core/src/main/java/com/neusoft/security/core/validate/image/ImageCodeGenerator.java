package com.neusoft.security.core.validate.image;

import com.github.botaruibo.xvcode.generator.Generator;
import com.github.botaruibo.xvcode.generator.PngVCGenerator;
import com.neusoft.security.core.properties.ImageProperties;
import com.neusoft.security.core.properties.SecurityProperties;
import com.neusoft.security.core.validate.entity.ValidateCode;
import com.neusoft.security.core.validate.generator.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.image.BufferedImage;

/**
 * <p>默认的图片验证码生成器</p>
 * <p>创建日期：2018-04-13</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
public class ImageCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        ImageProperties imageProperties = securityProperties.getValidateCode().getImage();
        Generator generator = new PngVCGenerator(imageProperties.getWidth(), imageProperties.getHeight(), imageProperties.getCount());
        BufferedImage bufferedImage = generator.getValidCodeImage();
        String validCode = generator.text();

        return new ImageValidateCode(bufferedImage, validCode, imageProperties.getExpireIn());
    }
}
