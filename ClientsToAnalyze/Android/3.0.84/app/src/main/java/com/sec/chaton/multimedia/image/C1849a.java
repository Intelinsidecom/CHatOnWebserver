package com.sec.chaton.multimedia.image;

import android.support.v4.view.MotionEventCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.sec.chaton.util.C3250y;

/* compiled from: GestureDetectorListener.java */
/* renamed from: com.sec.chaton.multimedia.image.a */
/* loaded from: classes.dex */
public class C1849a extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    ViewOnTouchListenerC1868as f7071a;

    public C1849a(ViewOnTouchListenerC1868as viewOnTouchListenerC1868as) {
        this.f7071a = viewOnTouchListenerC1868as;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                if (C3250y.f11734b) {
                    C3250y.m11450b("ACTION_DOUBLE_TAP", getClass().getSimpleName());
                }
                this.f7071a.m7703a(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f7071a.m7707c();
        return true;
    }
}
