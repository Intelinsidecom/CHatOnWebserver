package android.support.v4.app;

import android.os.Build;

/* compiled from: NotificationCompat.java */
/* renamed from: android.support.v4.app.ar */
/* loaded from: classes.dex */
public class C0032ar {

    /* renamed from: a */
    private static final InterfaceC0038ax f130a;

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f130a = new C0043bb();
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            f130a = new C0042ba();
        } else if (Build.VERSION.SDK_INT >= 11) {
            f130a = new C0040az();
        } else {
            f130a = new C0039ay();
        }
    }
}
