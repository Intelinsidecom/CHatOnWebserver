package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewCompat.java */
/* renamed from: android.support.v4.view.at */
/* loaded from: classes.dex */
public class C0159at {

    /* renamed from: a */
    static final InterfaceC0169bc f468a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            f468a = new C0168bb();
            return;
        }
        if (i >= 17) {
            f468a = new C0167ba();
            return;
        }
        if (i >= 16) {
            f468a = new C0165az();
            return;
        }
        if (i >= 14) {
            f468a = new C0164ay();
            return;
        }
        if (i >= 11) {
            f468a = new C0163ax();
        } else if (i >= 9) {
            f468a = new C0162aw();
        } else {
            f468a = new C0160au();
        }
    }

    /* renamed from: a */
    public static boolean m637a(View view, int i) {
        return f468a.mo652a(view, i);
    }

    /* renamed from: a */
    public static int m631a(View view) {
        return f468a.mo645a(view);
    }

    /* renamed from: a */
    public static void m635a(View view, C0109a c0109a) {
        f468a.mo650a(view, c0109a);
    }

    /* renamed from: b */
    public static void m638b(View view) {
        f468a.mo653b(view);
    }

    /* renamed from: a */
    public static void m632a(View view, int i, int i2, int i3, int i4) {
        f468a.mo647a(view, i, i2, i3, i4);
    }

    /* renamed from: a */
    public static void m636a(View view, Runnable runnable) {
        f468a.mo651a(view, runnable);
    }

    /* renamed from: c */
    public static int m640c(View view) {
        return f468a.mo655c(view);
    }

    /* renamed from: b */
    public static void m639b(View view, int i) {
        f468a.mo654b(view, i);
    }

    /* renamed from: a */
    public static void m633a(View view, int i, Paint paint) {
        f468a.mo648a(view, i, paint);
    }

    /* renamed from: d */
    public static int m641d(View view) {
        return f468a.mo656d(view);
    }

    /* renamed from: a */
    public static void m634a(View view, Paint paint) {
        f468a.mo649a(view, paint);
    }

    /* renamed from: e */
    public static int m642e(View view) {
        return f468a.mo657e(view);
    }

    /* renamed from: f */
    public static ViewParent m643f(View view) {
        return f468a.mo658f(view);
    }

    /* renamed from: g */
    public static boolean m644g(View view) {
        return f468a.mo659g(view);
    }
}
