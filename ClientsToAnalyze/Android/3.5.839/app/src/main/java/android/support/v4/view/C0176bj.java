package android.support.v4.view;

import android.os.Build;
import android.view.ViewConfiguration;

/* compiled from: ViewConfigurationCompat.java */
/* renamed from: android.support.v4.view.bj */
/* loaded from: classes.dex */
public class C0176bj {

    /* renamed from: a */
    static final InterfaceC0179bm f469a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f469a = new C0178bl();
        } else {
            f469a = new C0177bk();
        }
    }

    /* renamed from: a */
    public static int m684a(ViewConfiguration viewConfiguration) {
        return f469a.mo685a(viewConfiguration);
    }
}
