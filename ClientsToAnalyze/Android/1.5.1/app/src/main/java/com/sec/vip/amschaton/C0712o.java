package com.sec.vip.amschaton;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* renamed from: com.sec.vip.amschaton.o */
/* loaded from: classes.dex */
class C0712o extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f4343a;

    C0712o(ZoomableImageView zoomableImageView) {
        this.f4343a = zoomableImageView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.f4343a.f4228t) {
            return true;
        }
        this.f4343a.f4225q = 1.0f;
        this.f4343a.f4228t = true;
        this.f4343a.f4223o = motionEvent.getX();
        this.f4343a.f4224p = motionEvent.getY();
        if (Math.abs(this.f4343a.f4216h - this.f4343a.f4196B) > 0.1d) {
            this.f4343a.f4222n = this.f4343a.f4196B;
        } else {
            this.f4343a.f4222n = this.f4343a.f4195A;
        }
        this.f4343a.f4226r = this.f4343a.f4222n / this.f4343a.f4216h;
        this.f4343a.f4200F.removeCallbacks(this.f4343a.f4208N);
        this.f4343a.f4200F.post(this.f4343a.f4208N);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }
}
