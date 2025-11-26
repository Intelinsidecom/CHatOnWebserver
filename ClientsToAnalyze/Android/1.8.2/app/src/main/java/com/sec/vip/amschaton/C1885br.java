package com.sec.vip.amschaton;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.vip.amschaton.br */
/* loaded from: classes.dex */
class C1885br extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f6886a;

    C1885br(ZoomableImageView zoomableImageView) {
        this.f6886a = zoomableImageView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.f6886a.f6758t) {
            this.f6886a.f6755q = 1.0f;
            this.f6886a.f6758t = true;
            this.f6886a.f6753o = motionEvent.getX();
            this.f6886a.f6754p = motionEvent.getY();
            if (Math.abs(this.f6886a.f6746h - this.f6886a.f6730B) > 0.1d) {
                this.f6886a.f6752n = this.f6886a.f6730B;
            } else {
                this.f6886a.f6752n = this.f6886a.f6729A;
            }
            this.f6886a.f6756r = this.f6886a.f6752n / this.f6886a.f6746h;
            this.f6886a.f6734F.removeCallbacks(this.f6886a.f6738J);
            this.f6886a.f6734F.post(this.f6886a.f6738J);
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
