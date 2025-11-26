package android.support.v4.view;

import android.view.MotionEvent;

/* renamed from: android.support.v4.view.e */
/* loaded from: classes.dex */
class C0027e implements InterfaceC0024b {
    C0027e() {
    }

    @Override // android.support.v4.view.InterfaceC0024b
    /* renamed from: a */
    public int mo212a(MotionEvent motionEvent, int i) {
        return -1;
    }

    @Override // android.support.v4.view.InterfaceC0024b
    /* renamed from: b */
    public int mo213b(MotionEvent motionEvent, int i) {
        throw new IndexOutOfBoundsException("Pre-Eclair does not support pointers");
    }

    @Override // android.support.v4.view.InterfaceC0024b
    /* renamed from: c */
    public float mo214c(MotionEvent motionEvent, int i) {
        throw new IndexOutOfBoundsException("Pre-Eclair does not support pointers");
    }

    @Override // android.support.v4.view.InterfaceC0024b
    /* renamed from: d */
    public float mo215d(MotionEvent motionEvent, int i) {
        throw new IndexOutOfBoundsException("Pre-Eclair does not support pointers");
    }
}
