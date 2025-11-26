package android.support.v4.view.p009a;

import android.os.Build;
import android.os.Bundle;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat.java */
/* renamed from: android.support.v4.view.a.k */
/* loaded from: classes.dex */
public class C0124k {

    /* renamed from: a */
    private static final InterfaceC0125l f451a;

    /* renamed from: b */
    private final Object f452b;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f451a = new C0128o();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f451a = new C0126m();
        } else {
            f451a = new C0130q();
        }
    }

    public C0124k() {
        this.f452b = f451a.mo583a(this);
    }

    public C0124k(Object obj) {
        this.f452b = obj;
    }

    /* renamed from: a */
    public Object m580a() {
        return this.f452b;
    }

    /* renamed from: a */
    public C0110a m579a(int i) {
        return null;
    }

    /* renamed from: a */
    public boolean m582a(int i, int i2, Bundle bundle) {
        return false;
    }

    /* renamed from: a */
    public List<C0110a> m581a(String str, int i) {
        return null;
    }
}
