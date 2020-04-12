package com.neusoft.security.core.validate.image;

public class ImageResponseBody {

    private String deviceId;

    private String image;

    public ImageResponseBody(String deviceId, String image) {
        this.deviceId = deviceId;
        this.image = image;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
