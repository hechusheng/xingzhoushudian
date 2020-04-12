package com.neusoft.security.core.properties;

/**
 * <p>验证码属性配置</p></p>
 * <p>创建日期：2018-04-13</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class ValidateCodeProperties {

    private ImageProperties image = new ImageProperties();

    public ImageProperties getImage() {
        return image;
    }

    public void setImage(ImageProperties image) {
        this.image = image;
    }
}
