package android.support.v4.view.p009a;

import android.os.Build;

/* compiled from: AccessibilityRecordCompat.java */
/* renamed from: android.support.v4.view.a.x */
/* loaded from: classes.dex */
public class C0137x {

    /* renamed from: a */
    private static final InterfaceC0111aa f459a;

    /* renamed from: b */
    private final Object f460b;

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f459a = new C0112ab();
            return;
        }
        if (Build.VERSION.SDK_INT >= 15) {
            f459a = new C0139z();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f459a = new C0138y();
        } else {
            f459a = new C0113ac();
        }
    }

    public C0137x(Object obj) {
        this.f460b = obj;
    }

    /* renamed from: a */
    public static C0137x m592a() {
        return new C0137x(f459a.mo485a());
    }

    /* renamed from: a */
    public void m594a(boolean z) {
        f459a.mo487a(this.f460b, z);
    }

    /* renamed from: a */
    public void m593a(int i) {
        f459a.mo488b(this.f460b, i);
    }

    /* renamed from: b */
    public void m595b(int i) {
        f459a.mo486a(this.f460b, i);
    }

    /* renamed from: c */
    public void m596c(int i) {
        f459a.mo489c(this.f460b, i);
    }

    public int hashCode() {
        if (this.f460b == null) {
            return 0;
        }
        return this.f460b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C0137x c0137x = (C0137x) obj;
            return this.f460b == null ? c0137x.f460b == null : this.f460b.equals(c0137x.f460b);
        }
        return false;
    }
}
