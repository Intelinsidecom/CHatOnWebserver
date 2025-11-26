package android.support.v4.view;

import android.view.MotionEvent;

/* compiled from: MotionEventCompat.java */
/* renamed from: android.support.v4.view.aa */
/* loaded from: classes.dex */
class C0140aa implements InterfaceC0142ac {
    C0140aa() {
    }

    @Override // android.support.v4.view.InterfaceC0142ac
    /* renamed from: a */
    public int mo598a(MotionEvent motionEvent, int i) {
        return i == 0 ? 0 : -1;
    }

    @Override // android.support.v4.view.InterfaceC0142ac
    /* renamed from: b */
    public int mo599b(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    @Override // android.support.v4.view.InterfaceC0142ac
    /* renamed from: c */
    public float mo600c(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    @Override // android.support.v4.view.InterfaceC0142ac
    /* renamed from: d */
    public float mo601d(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    @Override // android.support.v4.view.InterfaceC0142ac
    /* renamed from: a */
    public int mo597a(MotionEvent motionEvent) {
        return 1;
    }
}
