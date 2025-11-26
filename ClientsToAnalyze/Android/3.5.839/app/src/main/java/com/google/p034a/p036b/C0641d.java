package com.google.p034a.p036b;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* compiled from: $Gson$Types.java */
/* renamed from: com.google.a.b.d */
/* loaded from: classes.dex */
final class C0641d implements Serializable, ParameterizedType {

    /* renamed from: a */
    private final Type f1508a;

    /* renamed from: b */
    private final Type f1509b;

    /* renamed from: c */
    private final Type[] f1510c;

    public C0641d(Type type, Type type2, Type... typeArr) {
        boolean z = true;
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            C0565a.m1952a(type != null || cls.getEnclosingClass() == null);
            if (type != null && cls.getEnclosingClass() == null) {
                z = false;
            }
            C0565a.m1952a(z);
        }
        this.f1508a = type == null ? null : C0639b.m2062d(type);
        this.f1509b = C0639b.m2062d(type2);
        this.f1510c = (Type[]) typeArr.clone();
        for (int i = 0; i < this.f1510c.length; i++) {
            C0565a.m1951a(this.f1510c[i]);
            C0639b.m2067i(this.f1510c[i]);
            this.f1510c[i] = C0639b.m2062d(this.f1510c[i]);
        }
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return (Type[]) this.f1510c.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f1509b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f1508a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && C0639b.m2056a((Type) this, (Type) obj);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f1510c) ^ this.f1509b.hashCode()) ^ C0639b.m2057b((Object) this.f1508a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f1510c.length + 1) * 30);
        sb.append(C0639b.m2064f(this.f1509b));
        if (this.f1510c.length == 0) {
            return sb.toString();
        }
        sb.append("<").append(C0639b.m2064f(this.f1510c[0]));
        for (int i = 1; i < this.f1510c.length; i++) {
            sb.append(", ").append(C0639b.m2064f(this.f1510c[i]));
        }
        return sb.append(">").toString();
    }
}
