package com.google.p034a.p036b;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* compiled from: $Gson$Types.java */
/* renamed from: com.google.a.b.c */
/* loaded from: classes.dex */
final class C0640c implements Serializable, GenericArrayType {

    /* renamed from: a */
    private final Type f1507a;

    public C0640c(Type type) {
        this.f1507a = C0639b.m2062d(type);
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.f1507a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && C0639b.m2056a((Type) this, (Type) obj);
    }

    public int hashCode() {
        return this.f1507a.hashCode();
    }

    public String toString() {
        return C0639b.m2064f(this.f1507a) + "[]";
    }
}
