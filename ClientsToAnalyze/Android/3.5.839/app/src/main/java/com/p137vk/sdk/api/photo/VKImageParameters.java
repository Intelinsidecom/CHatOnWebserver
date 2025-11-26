package com.p137vk.sdk.api.photo;

import com.p137vk.sdk.VKObject;

/* loaded from: classes.dex */
public class VKImageParameters extends VKObject {
    public VKImageType mImageType = VKImageType.Png;
    public float mJpegQuality;

    enum VKImageType {
        Jpg,
        Png
    }

    public static VKImageParameters pngImage() {
        VKImageParameters vKImageParameters = new VKImageParameters();
        vKImageParameters.mImageType = VKImageType.Png;
        return vKImageParameters;
    }

    public static VKImageParameters jpgImage(float f) {
        VKImageParameters vKImageParameters = new VKImageParameters();
        vKImageParameters.mImageType = VKImageType.Jpg;
        vKImageParameters.mJpegQuality = f;
        return vKImageParameters;
    }

    public String fileExtension() {
        switch (this.mImageType) {
            case Jpg:
                return "jpg";
            case Png:
                return "png";
            default:
                return "file";
        }
    }

    public String mimeType() {
        switch (this.mImageType) {
            case Jpg:
                return "image/jpeg";
            case Png:
                return "image/png";
            default:
                return "application/octet-stream";
        }
    }
}
