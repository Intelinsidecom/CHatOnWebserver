package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p036b.C0639b;
import com.google.p034a.p036b.C0643f;
import com.google.p034a.p038c.C0664a;
import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: CollectionTypeAdapterFactory.java */
/* renamed from: com.google.a.b.a.c */
/* loaded from: classes.dex */
public final class C0600c implements InterfaceC0563af {

    /* renamed from: a */
    private final C0643f f1393a;

    public C0600c(C0643f c0643f) {
        this.f1393a = c0643f;
    }

    @Override // com.google.p034a.InterfaceC0563af
    /* renamed from: a */
    public <T> AbstractC0562ae<T> mo1950a(C0676j c0676j, C0664a<T> c0664a) {
        Type typeM2104b = c0664a.m2104b();
        Class<? super T> clsM2103a = c0664a.m2103a();
        if (!Collection.class.isAssignableFrom(clsM2103a)) {
            return null;
        }
        Type typeM2051a = C0639b.m2051a(typeM2104b, (Class<?>) clsM2103a);
        return new C0601d(c0676j, typeM2051a, c0676j.m2157a((C0664a) C0664a.m2100a(typeM2051a)), this.f1393a.m2071a(c0664a));
    }
}
