package com.neusoft.security.core.validate.image;

import com.neusoft.security.core.validate.entity.ValidateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * <p>图片验证码</p>
 * <p>创建日期：2018-04-13</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class ImageValidateCode extends ValidateCode {

    private BufferedImage image;

    public ImageValidateCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

    public ImageValidateCode(String code, LocalDateTime expireTime, BufferedImage image) {
        super(code, expireTime);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
