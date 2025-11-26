package android.support.v4.view;

import android.os.Build;
import android.view.VelocityTracker;

/* compiled from: VelocityTrackerCompat.java */
/* renamed from: android.support.v4.view.ao */
/* loaded from: classes.dex */
public class C0154ao {

    /* renamed from: a */
    static final InterfaceC0157ar f467a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f467a = new C0156aq();
        } else {
            f467a = new C0155ap();
        }
    }

    /* renamed from: a */
    public static float m625a(VelocityTracker velocityTracker, int i) {
        return f467a.mo627a(velocityTracker, i);
    }

    /* renamed from: b */
    public static float m626b(VelocityTracker velocityTracker, int i) {
        return f467a.mo628b(velocityTracker, i);
    }
}
