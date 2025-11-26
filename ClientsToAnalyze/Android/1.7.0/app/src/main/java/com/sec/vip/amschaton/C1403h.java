package com.sec.vip.amschaton;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.vip.amschaton.h */
/* loaded from: classes.dex */
class C1403h extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f4925a;

    C1403h(ZoomableImageView zoomableImageView) {
        this.f4925a = zoomableImageView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.f4925a.f4770t) {
            this.f4925a.f4767q = 1.0f;
            this.f4925a.f4770t = true;
            this.f4925a.f4765o = motionEvent.getX();
            this.f4925a.f4766p = motionEvent.getY();
            if (Math.abs(this.f4925a.f4758h - this.f4925a.f4742B) > 0.1d) {
                this.f4925a.f4764n = this.f4925a.f4742B;
            } else {
                this.f4925a.f4764n = this.f4925a.f4741A;
            }
            this.f4925a.f4768r = this.f4925a.f4764n / this.f4925a.f4758h;
            this.f4925a.f4746F.removeCallbacks(this.f4925a.f4750J);
            this.f4925a.f4746F.post(this.f4925a.f4750J);
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
