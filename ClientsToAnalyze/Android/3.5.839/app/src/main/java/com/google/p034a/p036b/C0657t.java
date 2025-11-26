package com.google.p034a.p036b;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.p038c.C0664a;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import java.io.IOException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Excluder.java */
/* renamed from: com.google.a.b.t */
/* loaded from: classes.dex */
class C0657t<T> extends AbstractC0562ae<T> {

    /* renamed from: a */
    final /* synthetic */ boolean f1542a;

    /* renamed from: b */
    final /* synthetic */ boolean f1543b;

    /* renamed from: c */
    final /* synthetic */ C0676j f1544c;

    /* renamed from: d */
    final /* synthetic */ C0664a f1545d;

    /* renamed from: e */
    final /* synthetic */ C0656s f1546e;

    /* renamed from: f */
    private AbstractC0562ae<T> f1547f;

    C0657t(C0656s c0656s, boolean z, boolean z2, C0676j c0676j, C0664a c0664a) {
        this.f1546e = c0656s;
        this.f1542a = z;
        this.f1543b = z2;
        this.f1544c = c0676j;
        this.f1545d = c0664a;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: b */
    public T mo1949b(C0666a c0666a) throws IOException {
        if (!this.f1542a) {
            return m2081a().mo1949b(c0666a);
        }
        c0666a.mo2000n();
        return null;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a */
    public void mo1948a(C0669d c0669d, T t) throws IOException {
        if (this.f1543b) {
            c0669d.mo2014f();
        } else {
            m2081a().mo1948a(c0669d, t);
        }
    }

    /* renamed from: a */
    private AbstractC0562ae<T> m2081a() {
        AbstractC0562ae<T> abstractC0562ae = this.f1547f;
        if (abstractC0562ae != null) {
            return abstractC0562ae;
        }
        AbstractC0562ae<T> abstractC0562aeM2156a = this.f1544c.m2156a(this.f1546e, this.f1545d);
        this.f1547f = abstractC0562aeM2156a;
        return abstractC0562aeM2156a;
    }
}
