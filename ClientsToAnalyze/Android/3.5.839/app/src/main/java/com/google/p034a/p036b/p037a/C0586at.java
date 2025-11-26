package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p038c.C0664a;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.at */
/* loaded from: classes.dex */
final class C0586at implements InterfaceC0563af {

    /* renamed from: a */
    final /* synthetic */ Class f1380a;

    /* renamed from: b */
    final /* synthetic */ AbstractC0562ae f1381b;

    C0586at(Class cls, AbstractC0562ae abstractC0562ae) {
        this.f1380a = cls;
        this.f1381b = abstractC0562ae;
    }

    @Override // com.google.p034a.InterfaceC0563af
    /* renamed from: a */
    public <T> AbstractC0562ae<T> mo1950a(C0676j c0676j, C0664a<T> c0664a) {
        if (c0664a.m2103a() == this.f1380a) {
            return this.f1381b;
        }
        return null;
    }

    public String toString() {
        return "Factory[type=" + this.f1380a.getName() + ",adapter=" + this.f1381b + "]";
    }
}
