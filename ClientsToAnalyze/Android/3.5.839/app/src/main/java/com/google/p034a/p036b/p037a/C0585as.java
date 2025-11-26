package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p038c.C0664a;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.as */
/* loaded from: classes.dex */
final class C0585as implements InterfaceC0563af {
    C0585as() {
    }

    @Override // com.google.p034a.InterfaceC0563af
    /* renamed from: a */
    public <T> AbstractC0562ae<T> mo1950a(C0676j c0676j, C0664a<T> c0664a) {
        Class<? super T> clsM2103a = c0664a.m2103a();
        if (!Enum.class.isAssignableFrom(clsM2103a) || clsM2103a == Enum.class) {
            return null;
        }
        if (!clsM2103a.isEnum()) {
            clsM2103a = clsM2103a.getSuperclass();
        }
        return new C0599bf(clsM2103a);
    }
}
