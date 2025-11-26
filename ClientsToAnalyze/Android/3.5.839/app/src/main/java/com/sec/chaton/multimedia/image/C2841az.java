package com.sec.chaton.multimedia.image;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.chaton.multimedia.image.az */
/* loaded from: classes.dex */
class C2841az extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f10436a;

    C2841az(ZoomableImageView zoomableImageView) {
        this.f10436a = zoomableImageView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.f10436a.f10368r) {
            this.f10436a.f10365o = 1.0f;
            this.f10436a.f10368r = true;
            this.f10436a.f10363m = motionEvent.getX();
            this.f10436a.f10364n = motionEvent.getY();
            if (Math.abs(this.f10436a.f10355e - this.f10436a.f10373w) > 0.1d) {
                this.f10436a.f10362l = this.f10436a.f10373w;
            } else {
                this.f10436a.f10362l = this.f10436a.f10372v;
            }
            this.f10436a.f10366p = this.f10436a.f10362l / this.f10436a.f10355e;
            this.f10436a.f10346D.removeCallbacks(this.f10436a.f10350H);
            this.f10436a.f10346D.post(this.f10436a.f10350H);
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
