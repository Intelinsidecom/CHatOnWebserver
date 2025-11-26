package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p036b.C0639b;
import com.google.p034a.p038c.C0664a;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* compiled from: ArrayTypeAdapter.java */
/* renamed from: com.google.a.b.a.b */
/* loaded from: classes.dex */
final class C0593b implements InterfaceC0563af {
    C0593b() {
    }

    @Override // com.google.p034a.InterfaceC0563af
    /* renamed from: a */
    public <T> AbstractC0562ae<T> mo1950a(C0676j c0676j, C0664a<T> c0664a) {
        Type typeM2104b = c0664a.m2104b();
        if (!(typeM2104b instanceof GenericArrayType) && (!(typeM2104b instanceof Class) || !((Class) typeM2104b).isArray())) {
            return null;
        }
        Type typeM2065g = C0639b.m2065g(typeM2104b);
        return new C0566a(c0676j, c0676j.m2157a((C0664a) C0664a.m2100a(typeM2065g)), C0639b.m2063e(typeM2065g));
    }
}
