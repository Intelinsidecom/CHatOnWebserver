package com.sec.chaton.common.entry;

import android.graphics.Bitmap;
import com.sec.chaton.util.ImageDownloader;

/* loaded from: classes.dex */
public class ImageRequestResult {

    /* renamed from: a */
    Bitmap f1311a;

    /* renamed from: b */
    ImageDownloader.ImageDownResult f1312b;

    public ImageRequestResult(Bitmap bitmap, ImageDownloader.ImageDownResult imageDownResult) {
        this.f1311a = bitmap;
        this.f1312b = imageDownResult;
    }

    /* renamed from: a */
    public Bitmap m1960a() {
        return this.f1311a;
    }

    /* renamed from: a */
    public void m1961a(Bitmap bitmap) {
        this.f1311a = bitmap;
    }

    /* renamed from: b */
    public ImageDownloader.ImageDownResult m1962b() {
        return this.f1312b;
    }
}
