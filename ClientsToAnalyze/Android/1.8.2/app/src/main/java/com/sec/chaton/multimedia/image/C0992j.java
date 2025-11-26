package com.sec.chaton.multimedia.image;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: ZoomableImageView.java */
/* renamed from: com.sec.chaton.multimedia.image.j */
/* loaded from: classes.dex */
class C0992j extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ ZoomableImageView f3664a;

    private C0992j(ZoomableImageView zoomableImageView) {
        this.f3664a = zoomableImageView;
    }

    /* synthetic */ C0992j(ZoomableImageView zoomableImageView, RunnableC0988f runnableC0988f) {
        this(zoomableImageView);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return super.onSingleTapConfirmed(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent.getPointerCount() > 1) {
            return false;
        }
        if (motionEvent2 != null && motionEvent2.getPointerCount() > 1) {
            return false;
        }
        if (this.f3664a.f3634o != null && this.f3664a.f3634o.isInProgress()) {
            return false;
        }
        if (this.f3664a.m3876a() > this.f3664a.m3887d()) {
            this.f3664a.removeCallbacks(this.f3664a.f3632m);
            this.f3664a.m3880a(-f, -f2);
            this.f3664a.m3883a(true, true, false);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.f3664a.m3876a() > this.f3664a.m3887d()) {
            this.f3664a.m3879a(this.f3664a.m3887d());
            return true;
        }
        this.f3664a.m3882a(this.f3664a.m3887d() * 3.0f, motionEvent.getX(), motionEvent.getY(), 200.0f);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent.getPointerCount() > 1) {
            return false;
        }
        if ((motionEvent2 != null && motionEvent2.getPointerCount() > 1) || this.f3664a.f3634o.isInProgress()) {
            return false;
        }
        try {
            float x = motionEvent2.getX() - motionEvent.getX();
            float y = motionEvent2.getY() - motionEvent.getY();
            if (Math.abs(f) > 800.0f || Math.abs(f2) > 800.0f) {
                this.f3664a.m3885b(x / 2.0f, y / 2.0f, 300.0f);
                this.f3664a.invalidate();
            }
        } catch (NullPointerException e) {
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }
}
