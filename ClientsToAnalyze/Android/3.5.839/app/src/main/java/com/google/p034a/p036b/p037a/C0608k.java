package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p036b.C0639b;
import com.google.p034a.p036b.C0643f;
import com.google.p034a.p038c.C0664a;
import java.lang.reflect.Type;
import java.util.Map;

/* compiled from: MapTypeAdapterFactory.java */
/* renamed from: com.google.a.b.a.k */
/* loaded from: classes.dex */
public final class C0608k implements InterfaceC0563af {

    /* renamed from: a */
    private final C0643f f1408a;

    /* renamed from: b */
    private final boolean f1409b;

    public C0608k(C0643f c0643f, boolean z) {
        this.f1408a = c0643f;
        this.f1409b = z;
    }

    @Override // com.google.p034a.InterfaceC0563af
    /* renamed from: a */
    public <T> AbstractC0562ae<T> mo1950a(C0676j c0676j, C0664a<T> c0664a) throws NoSuchMethodException, SecurityException {
        Type typeM2104b = c0664a.m2104b();
        if (!Map.class.isAssignableFrom(c0664a.m2103a())) {
            return null;
        }
        Type[] typeArrM2060b = C0639b.m2060b(typeM2104b, C0639b.m2063e(typeM2104b));
        return new C0609l(this, c0676j, typeArrM2060b[0], m2015a(c0676j, typeArrM2060b[0]), typeArrM2060b[1], c0676j.m2157a((C0664a) C0664a.m2100a(typeArrM2060b[1])), this.f1408a.m2071a(c0664a));
    }

    /* renamed from: a */
    private AbstractC0562ae<?> m2015a(C0676j c0676j, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? C0622y.f1461f : c0676j.m2157a((C0664a) C0664a.m2100a(type));
    }
}
