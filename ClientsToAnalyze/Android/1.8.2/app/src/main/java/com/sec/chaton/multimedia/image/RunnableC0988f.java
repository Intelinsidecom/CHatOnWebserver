package com.sec.chaton.multimedia.image;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.chaton.multimedia.image.f */
/* loaded from: classes.dex */
class RunnableC0988f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f3647a;

    RunnableC0988f(ZoomableImageView zoomableImageView) {
        this.f3647a = zoomableImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3647a.postInvalidate();
    }
}
