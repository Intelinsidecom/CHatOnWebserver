package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.p038c.C0664a;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* renamed from: com.google.a.b.a.x */
/* loaded from: classes.dex */
final class C0621x<T> extends AbstractC0562ae<T> {

    /* renamed from: a */
    private final C0676j f1435a;

    /* renamed from: b */
    private final AbstractC0562ae<T> f1436b;

    /* renamed from: c */
    private final Type f1437c;

    C0621x(C0676j c0676j, AbstractC0562ae<T> abstractC0562ae, Type type) {
        this.f1435a = c0676j;
        this.f1436b = abstractC0562ae;
        this.f1437c = type;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: b */
    public T mo1949b(C0666a c0666a) {
        return this.f1436b.mo1949b(c0666a);
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a */
    public void mo1948a(C0669d c0669d, T t) {
        AbstractC0562ae<T> abstractC0562aeM2157a = this.f1436b;
        Type typeM2028a = m2028a(this.f1437c, t);
        if (typeM2028a != this.f1437c) {
            abstractC0562aeM2157a = this.f1435a.m2157a((C0664a) C0664a.m2100a(typeM2028a));
            if ((abstractC0562aeM2157a instanceof C0615r) && !(this.f1436b instanceof C0615r)) {
                abstractC0562aeM2157a = this.f1436b;
            }
        }
        abstractC0562aeM2157a.mo1948a(c0669d, t);
    }

    /* renamed from: a */
    private Type m2028a(Type type, Object obj) {
        if (obj == null) {
            return type;
        }
        if (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) {
            return obj.getClass();
        }
        return type;
    }
}
