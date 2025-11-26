package com.facebook.p033c;

/* compiled from: WorkQueue.java */
/* renamed from: com.facebook.c.aa */
/* loaded from: classes.dex */
class C0504aa implements InterfaceC0529z {

    /* renamed from: a */
    static final /* synthetic */ boolean f1262a;

    /* renamed from: b */
    final /* synthetic */ C0527x f1263b;

    /* renamed from: c */
    private final Runnable f1264c;

    /* renamed from: d */
    private C0504aa f1265d;

    /* renamed from: e */
    private C0504aa f1266e;

    /* renamed from: f */
    private boolean f1267f;

    static {
        f1262a = !C0527x.class.desiredAssertionStatus();
    }

    C0504aa(C0527x c0527x, Runnable runnable) {
        this.f1263b = c0527x;
        this.f1264c = runnable;
    }

    @Override // com.facebook.p033c.InterfaceC0529z
    /* renamed from: a */
    public void mo1859a() {
        synchronized (this.f1263b.f1325b) {
            if (!m1861b()) {
                this.f1263b.f1326c = m1857a(this.f1263b.f1326c);
                this.f1263b.f1326c = m1858a(this.f1263b.f1326c, true);
            }
        }
    }

    /* renamed from: b */
    public boolean m1861b() {
        return this.f1267f;
    }

    /* renamed from: c */
    Runnable m1862c() {
        return this.f1264c;
    }

    /* renamed from: a */
    void m1860a(boolean z) {
        this.f1267f = z;
    }

    /* renamed from: a */
    C0504aa m1858a(C0504aa c0504aa, boolean z) {
        C0504aa c0504aa2;
        if (!f1262a && this.f1265d != null) {
            throw new AssertionError();
        }
        if (!f1262a && this.f1266e != null) {
            throw new AssertionError();
        }
        if (c0504aa == null) {
            this.f1266e = this;
            this.f1265d = this;
            c0504aa2 = this;
        } else {
            this.f1265d = c0504aa;
            this.f1266e = c0504aa.f1266e;
            C0504aa c0504aa3 = this.f1265d;
            this.f1266e.f1265d = this;
            c0504aa3.f1266e = this;
            c0504aa2 = c0504aa;
        }
        return z ? this : c0504aa2;
    }

    /* renamed from: a */
    C0504aa m1857a(C0504aa c0504aa) {
        if (!f1262a && this.f1265d == null) {
            throw new AssertionError();
        }
        if (!f1262a && this.f1266e == null) {
            throw new AssertionError();
        }
        if (c0504aa == this) {
            c0504aa = this.f1265d == this ? null : this.f1265d;
        }
        this.f1265d.f1266e = this.f1266e;
        this.f1266e.f1265d = this.f1265d;
        this.f1266e = null;
        this.f1265d = null;
        return c0504aa;
    }
}
