package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p038c.C0664a;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.ax */
/* loaded from: classes.dex */
final class C0590ax implements InterfaceC0563af {

    /* renamed from: a */
    final /* synthetic */ Class f1388a;

    /* renamed from: b */
    final /* synthetic */ AbstractC0562ae f1389b;

    C0590ax(Class cls, AbstractC0562ae abstractC0562ae) {
        this.f1388a = cls;
        this.f1389b = abstractC0562ae;
    }

    @Override // com.google.p034a.InterfaceC0563af
    /* renamed from: a */
    public <T> AbstractC0562ae<T> mo1950a(C0676j c0676j, C0664a<T> c0664a) {
        if (this.f1388a.isAssignableFrom(c0664a.m2103a())) {
            return this.f1389b;
        }
        return null;
    }

    public String toString() {
        return "Factory[typeHierarchy=" + this.f1388a.getName() + ",adapter=" + this.f1389b + "]";
    }
}
