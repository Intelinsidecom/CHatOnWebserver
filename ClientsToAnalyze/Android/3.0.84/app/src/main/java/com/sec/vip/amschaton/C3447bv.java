package com.sec.vip.amschaton;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.vip.amschaton.bv */
/* loaded from: classes.dex */
class C3447bv extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f12609a;

    C3447bv(ZoomableImageView zoomableImageView) {
        this.f12609a = zoomableImageView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.f12609a.f12425w) {
            this.f12609a.f12422t = 1.0f;
            this.f12609a.f12425w = true;
            this.f12609a.f12420r = motionEvent.getX();
            this.f12609a.f12421s = motionEvent.getY();
            if (Math.abs(this.f12609a.f12413k - this.f12609a.f12397E) > 0.1d) {
                this.f12609a.f12419q = this.f12609a.f12397E;
            } else {
                this.f12609a.f12419q = this.f12609a.f12396D;
            }
            this.f12609a.f12423u = this.f12609a.f12419q / this.f12609a.f12413k;
            this.f12609a.f12406d.removeCallbacks(this.f12609a.f12402J);
            this.f12609a.f12406d.post(this.f12609a.f12402J);
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
