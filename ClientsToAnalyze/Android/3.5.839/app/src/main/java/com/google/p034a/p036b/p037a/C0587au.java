package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p038c.C0664a;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.au */
/* loaded from: classes.dex */
final class C0587au implements InterfaceC0563af {

    /* renamed from: a */
    final /* synthetic */ Class f1382a;

    /* renamed from: b */
    final /* synthetic */ Class f1383b;

    /* renamed from: c */
    final /* synthetic */ AbstractC0562ae f1384c;

    C0587au(Class cls, Class cls2, AbstractC0562ae abstractC0562ae) {
        this.f1382a = cls;
        this.f1383b = cls2;
        this.f1384c = abstractC0562ae;
    }

    @Override // com.google.p034a.InterfaceC0563af
    /* renamed from: a */
    public <T> AbstractC0562ae<T> mo1950a(C0676j c0676j, C0664a<T> c0664a) {
        Class<? super T> clsM2103a = c0664a.m2103a();
        if (clsM2103a == this.f1382a || clsM2103a == this.f1383b) {
            return this.f1384c;
        }
        return null;
    }

    public String toString() {
        return "Factory[type=" + this.f1383b.getName() + "+" + this.f1382a.getName() + ",adapter=" + this.f1384c + "]";
    }
}
