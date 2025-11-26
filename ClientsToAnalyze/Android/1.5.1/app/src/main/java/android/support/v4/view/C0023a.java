package android.support.v4.view;

import android.view.MotionEvent;

/* renamed from: android.support.v4.view.a */
/* loaded from: classes.dex */
class C0023a {
    C0023a() {
    }

    /* renamed from: a */
    public static int m208a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    /* renamed from: b */
    public static int m209b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    /* renamed from: c */
    public static float m210c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    /* renamed from: d */
    public static float m211d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }
}
