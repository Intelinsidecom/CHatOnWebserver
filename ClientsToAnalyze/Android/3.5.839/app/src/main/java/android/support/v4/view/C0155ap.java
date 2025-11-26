package android.support.v4.view;

import android.view.VelocityTracker;

/* compiled from: VelocityTrackerCompat.java */
/* renamed from: android.support.v4.view.ap */
/* loaded from: classes.dex */
class C0155ap implements InterfaceC0157ar {
    C0155ap() {
    }

    @Override // android.support.v4.view.InterfaceC0157ar
    /* renamed from: a */
    public float mo627a(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getXVelocity();
    }

    @Override // android.support.v4.view.InterfaceC0157ar
    /* renamed from: b */
    public float mo628b(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getYVelocity();
    }
}
