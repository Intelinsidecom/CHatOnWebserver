package com.sec.chaton.p022h;

import android.os.Handler;

/* compiled from: NetResultReceiver.java */
/* renamed from: com.sec.chaton.h.o */
/* loaded from: classes.dex */
public class C0805o {

    /* renamed from: a */
    final Handler f2964a;

    /* renamed from: b */
    private InterfaceC0807q f2965b;

    public C0805o(Handler handler, InterfaceC0807q interfaceC0807q) {
        this.f2964a = handler;
        m3417a(interfaceC0807q);
    }

    /* renamed from: a */
    public void m3417a(InterfaceC0807q interfaceC0807q) {
        this.f2965b = interfaceC0807q;
    }

    /* renamed from: a */
    public void m3415a(int i, Object obj) {
        this.f2964a.post(new RunnableC0806p(this, i, obj));
    }

    /* renamed from: a */
    public void m3416a(int i, Object obj, Object obj2) {
        this.f2964a.post(new RunnableC0808r(this, i, obj, obj2));
    }

    /* renamed from: b */
    protected void m3419b(int i, Object obj, Object obj2) {
        if (this.f2965b != null) {
            this.f2965b.mo2782a(i, obj, obj2);
        }
    }

    /* renamed from: b */
    protected void m3418b(int i, Object obj) {
        if (this.f2965b != null) {
            this.f2965b.mo2781a(i, obj);
        }
    }
}
