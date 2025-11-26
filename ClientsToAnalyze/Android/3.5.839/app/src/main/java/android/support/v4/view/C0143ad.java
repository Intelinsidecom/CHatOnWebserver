package android.support.v4.view;

import android.view.MotionEvent;

/* compiled from: MotionEventCompatEclair.java */
/* renamed from: android.support.v4.view.ad */
/* loaded from: classes.dex */
class C0143ad {
    /* renamed from: a */
    public static int m603a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    /* renamed from: b */
    public static int m604b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    /* renamed from: c */
    public static float m605c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    /* renamed from: d */
    public static float m606d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    /* renamed from: a */
    public static int m602a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }
}
