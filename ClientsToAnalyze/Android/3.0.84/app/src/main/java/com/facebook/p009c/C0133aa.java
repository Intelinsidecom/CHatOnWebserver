package com.facebook.p009c;

/* compiled from: WorkQueue.java */
/* renamed from: com.facebook.c.aa */
/* loaded from: classes.dex */
class C0133aa implements InterfaceC0158z {

    /* renamed from: a */
    static final /* synthetic */ boolean f293a;

    /* renamed from: b */
    final /* synthetic */ C0156x f294b;

    /* renamed from: c */
    private final Runnable f295c;

    /* renamed from: d */
    private C0133aa f296d;

    /* renamed from: e */
    private C0133aa f297e;

    /* renamed from: f */
    private boolean f298f;

    static {
        f293a = !C0156x.class.desiredAssertionStatus();
    }

    C0133aa(C0156x c0156x, Runnable runnable) {
        this.f294b = c0156x;
        this.f295c = runnable;
    }

    @Override // com.facebook.p009c.InterfaceC0158z
    /* renamed from: a */
    public void mo416a() {
        synchronized (this.f294b.f355b) {
            if (!m418b()) {
                this.f294b.f356c = m414a(this.f294b.f356c);
                this.f294b.f356c = m415a(this.f294b.f356c, true);
            }
        }
    }

    /* renamed from: b */
    public boolean m418b() {
        return this.f298f;
    }

    /* renamed from: c */
    Runnable m419c() {
        return this.f295c;
    }

    /* renamed from: a */
    void m417a(boolean z) {
        this.f298f = z;
    }

    /* renamed from: a */
    C0133aa m415a(C0133aa c0133aa, boolean z) {
        C0133aa c0133aa2;
        if (!f293a && this.f296d != null) {
            throw new AssertionError();
        }
        if (!f293a && this.f297e != null) {
            throw new AssertionError();
        }
        if (c0133aa == null) {
            this.f297e = this;
            this.f296d = this;
            c0133aa2 = this;
        } else {
            this.f296d = c0133aa;
            this.f297e = c0133aa.f297e;
            C0133aa c0133aa3 = this.f296d;
            this.f297e.f296d = this;
            c0133aa3.f297e = this;
            c0133aa2 = c0133aa;
        }
        return z ? this : c0133aa2;
    }

    /* renamed from: a */
    C0133aa m414a(C0133aa c0133aa) {
        if (!f293a && this.f296d == null) {
            throw new AssertionError();
        }
        if (!f293a && this.f297e == null) {
            throw new AssertionError();
        }
        if (c0133aa == this) {
            c0133aa = this.f296d == this ? null : this.f296d;
        }
        this.f296d.f297e = this.f297e;
        this.f297e.f296d = this.f296d;
        this.f297e = null;
        this.f296d = null;
        return c0133aa;
    }
}
