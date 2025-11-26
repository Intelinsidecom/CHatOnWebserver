package com.p137vk.sdk.api.photo;

import android.app.Activity;
import android.graphics.Bitmap;
import com.p137vk.sdk.VKObject;
import com.p137vk.sdk.VKUIHelper;
import com.p137vk.sdk.api.photo.VKImageParameters;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class VKUploadImage extends VKObject {
    public Bitmap mImageData;
    public VKImageParameters mParameters;

    public VKUploadImage(Bitmap bitmap, VKImageParameters vKImageParameters) {
        this.mImageData = bitmap;
        this.mParameters = vKImageParameters;
    }

    public File getTmpFile() throws IOException {
        File externalCacheDir;
        File fileCreateTempFile;
        IOException e;
        Activity topActivity = VKUIHelper.getTopActivity();
        if (topActivity != null) {
            externalCacheDir = topActivity.getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = topActivity.getCacheDir();
            }
        } else {
            externalCacheDir = null;
        }
        try {
            fileCreateTempFile = File.createTempFile("tmpImg", String.format(".%s", this.mParameters.fileExtension()), externalCacheDir);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                if (this.mParameters.mImageType == VKImageParameters.VKImageType.Png) {
                    this.mImageData.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                } else {
                    this.mImageData.compress(Bitmap.CompressFormat.JPEG, (int) (this.mParameters.mJpegQuality * 100.0f), fileOutputStream);
                }
                fileOutputStream.close();
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                return fileCreateTempFile;
            }
        } catch (IOException e3) {
            fileCreateTempFile = null;
            e = e3;
        }
        return fileCreateTempFile;
    }
}
