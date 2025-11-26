package android.support.v4.widget;

import android.content.Context;
import android.os.Build;
import android.view.animation.Interpolator;

/* compiled from: ScrollerCompat.java */
/* renamed from: android.support.v4.widget.t */
/* loaded from: classes.dex */
public class C0260t {

    /* renamed from: b */
    static final InterfaceC0261u f601b;

    /* renamed from: a */
    Object f602a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 14) {
            f601b = new C0264x();
        } else if (i >= 9) {
            f601b = new C0263w();
        } else {
            f601b = new C0262v();
        }
    }

    /* renamed from: a */
    public static C0260t m911a(Context context, Interpolator interpolator) {
        return new C0260t(context, interpolator);
    }

    C0260t(Context context, Interpolator interpolator) {
        this.f602a = f601b.mo920a(context, interpolator);
    }

    /* renamed from: a */
    public boolean m913a() {
        return f601b.mo922a(this.f602a);
    }

    /* renamed from: b */
    public int m914b() {
        return f601b.mo923b(this.f602a);
    }

    /* renamed from: c */
    public int m915c() {
        return f601b.mo924c(this.f602a);
    }

    /* renamed from: d */
    public int m916d() {
        return f601b.mo927f(this.f602a);
    }

    /* renamed from: e */
    public int m917e() {
        return f601b.mo928g(this.f602a);
    }

    /* renamed from: f */
    public boolean m918f() {
        return f601b.mo925d(this.f602a);
    }

    /* renamed from: a */
    public void m912a(int i, int i2, int i3, int i4, int i5) {
        f601b.mo921a(this.f602a, i, i2, i3, i4, i5);
    }

    /* renamed from: g */
    public void m919g() {
        f601b.mo926e(this.f602a);
    }
}
