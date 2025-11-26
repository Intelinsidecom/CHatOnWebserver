package com.google.p034a;

import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;

/* compiled from: Gson.java */
/* renamed from: com.google.a.p */
/* loaded from: classes.dex */
class C0682p<T> extends AbstractC0562ae<T> {

    /* renamed from: a */
    private AbstractC0562ae<T> f1621a;

    C0682p() {
    }

    /* renamed from: a */
    public void m2173a(AbstractC0562ae<T> abstractC0562ae) {
        if (this.f1621a != null) {
            throw new AssertionError();
        }
        this.f1621a = abstractC0562ae;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: b */
    public T mo1949b(C0666a c0666a) {
        if (this.f1621a == null) {
            throw new IllegalStateException();
        }
        return this.f1621a.mo1949b(c0666a);
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a */
    public void mo1948a(C0669d c0669d, T t) {
        if (this.f1621a == null) {
            throw new IllegalStateException();
        }
        this.f1621a.mo1948a(c0669d, t);
    }
}
