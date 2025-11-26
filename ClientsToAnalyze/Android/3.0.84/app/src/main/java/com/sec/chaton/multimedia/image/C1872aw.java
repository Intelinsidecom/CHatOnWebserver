package com.sec.chaton.multimedia.image;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.chaton.multimedia.image.aw */
/* loaded from: classes.dex */
class C1872aw extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f7125a;

    C1872aw(ZoomableImageView zoomableImageView) {
        this.f7125a = zoomableImageView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.f7125a.f7062r) {
            this.f7125a.f7059o = 1.0f;
            this.f7125a.f7062r = true;
            this.f7125a.f7057m = motionEvent.getX();
            this.f7125a.f7058n = motionEvent.getY();
            if (Math.abs(this.f7125a.f7049e - this.f7125a.f7067w) > 0.1d) {
                this.f7125a.f7056l = this.f7125a.f7067w;
            } else {
                this.f7125a.f7056l = this.f7125a.f7066v;
            }
            this.f7125a.f7060p = this.f7125a.f7056l / this.f7125a.f7049e;
            this.f7125a.f7040D.removeCallbacks(this.f7125a.f7044H);
            this.f7125a.f7040D.post(this.f7125a.f7044H);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }
}
