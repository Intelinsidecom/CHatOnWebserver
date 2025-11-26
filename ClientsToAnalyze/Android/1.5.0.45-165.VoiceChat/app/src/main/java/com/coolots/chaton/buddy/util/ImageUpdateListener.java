package com.coolots.chaton.buddy.util;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public interface ImageUpdateListener {
    void onDownloadFail();

    void onImageUpdate(Bitmap bitmap);
}
