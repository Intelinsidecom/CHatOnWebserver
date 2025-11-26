package com.sec.chaton.multimedia.image;

import android.view.ScaleGestureDetector;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.chaton.multimedia.image.k */
/* loaded from: classes.dex */
class C0993k extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f3665a;

    C0993k(ZoomableImageView zoomableImageView) {
        this.f3665a = zoomableImageView;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        if (scaleGestureDetector != null && scaleGestureDetector.isInProgress()) {
            try {
                this.f3665a.m3881a(Math.min(this.f3665a.m3886c(), Math.max(this.f3665a.m3876a() * scaleGestureDetector.getScaleFactor(), this.f3665a.m3887d())), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                this.f3665a.invalidate();
                return true;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
