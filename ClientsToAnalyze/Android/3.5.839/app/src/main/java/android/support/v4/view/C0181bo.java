package android.support.v4.view;

import android.os.Build;
import android.view.ViewGroup;

/* compiled from: ViewGroupCompat.java */
/* renamed from: android.support.v4.view.bo */
/* loaded from: classes.dex */
public class C0181bo {

    /* renamed from: a */
    static final InterfaceC0184br f470a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            f470a = new C0185bs();
            return;
        }
        if (i >= 14) {
            f470a = new C0183bq();
        } else if (i >= 11) {
            f470a = new C0182bp();
        } else {
            f470a = new C0186bt();
        }
    }

    /* renamed from: a */
    public static void m687a(ViewGroup viewGroup, boolean z) {
        f470a.mo688a(viewGroup, z);
    }
}
