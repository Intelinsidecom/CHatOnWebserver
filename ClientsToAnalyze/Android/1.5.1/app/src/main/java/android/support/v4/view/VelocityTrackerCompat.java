package android.support.v4.view;

import android.os.Build;
import android.view.VelocityTracker;

/* loaded from: classes.dex */
public class VelocityTrackerCompat {

    /* renamed from: a */
    static final InterfaceC0026d f146a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f146a = new C0029g();
        } else {
            f146a = new C0035m();
        }
    }

    /* renamed from: a */
    public static float m192a(VelocityTracker velocityTracker, int i) {
        return f146a.mo216a(velocityTracker, i);
    }
}
