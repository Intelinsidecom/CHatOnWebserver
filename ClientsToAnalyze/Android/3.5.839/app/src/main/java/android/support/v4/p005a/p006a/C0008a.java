package android.support.v4.p005a.p006a;

import android.graphics.drawable.Drawable;
import android.os.Build;

/* compiled from: DrawableCompat.java */
/* renamed from: android.support.v4.a.a.a */
/* loaded from: classes.dex */
public class C0008a {

    /* renamed from: a */
    static final InterfaceC0010c f33a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            f33a = new C0012e();
        } else if (i >= 11) {
            f33a = new C0011d();
        } else {
            f33a = new C0009b();
        }
    }

    /* renamed from: a */
    public static void m25a(Drawable drawable, boolean z) {
        f33a.mo27a(drawable, z);
    }

    /* renamed from: a */
    public static boolean m26a(Drawable drawable) {
        return f33a.mo28a(drawable);
    }
}
