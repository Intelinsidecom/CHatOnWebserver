package com.sec.chaton.p018c;

import android.os.Handler;

/* compiled from: NetResultReceiver.java */
/* renamed from: com.sec.chaton.c.c */
/* loaded from: classes.dex */
public class C0490c {

    /* renamed from: a */
    final Handler f1578a;

    /* renamed from: b */
    private InterfaceC0504k f1579b;

    public C0490c(Handler handler, InterfaceC0504k interfaceC0504k) {
        this.f1578a = handler;
        m2490a(interfaceC0504k);
    }

    /* renamed from: a */
    public void m2490a(InterfaceC0504k interfaceC0504k) {
        this.f1579b = interfaceC0504k;
    }

    /* renamed from: a */
    public void m2488a(int i, Object obj) {
        this.f1578a.post(new RunnableC0479b(this, i, obj));
    }

    /* renamed from: a */
    public void m2489a(int i, Object obj, Object obj2) {
        this.f1578a.post(new RunnableC0500g(this, i, obj, obj2));
    }

    /* renamed from: b */
    protected void m2492b(int i, Object obj, Object obj2) {
        if (this.f1579b != null) {
            this.f1579b.mo669a(i, obj, obj2);
        }
    }

    /* renamed from: b */
    protected void m2491b(int i, Object obj) {
        if (this.f1579b != null) {
            this.f1579b.mo668a(i, obj);
        }
    }
}
