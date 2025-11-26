package com.sec.chaton.multimedia.image;

import android.graphics.Bitmap;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.chaton.multimedia.image.g */
/* loaded from: classes.dex */
class RunnableC0989g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Bitmap f3648a;

    /* renamed from: b */
    final /* synthetic */ ZoomableImageView f3649b;

    RunnableC0989g(ZoomableImageView zoomableImageView, Bitmap bitmap) {
        this.f3649b = zoomableImageView;
        this.f3648a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3649b.setImageBitmap(this.f3648a);
    }
}
