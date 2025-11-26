package com.google.p034a.p036b;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* compiled from: $Gson$Types.java */
/* renamed from: com.google.a.b.e */
/* loaded from: classes.dex */
final class C0642e implements Serializable, WildcardType {

    /* renamed from: a */
    private final Type f1511a;

    /* renamed from: b */
    private final Type f1512b;

    public C0642e(Type[] typeArr, Type[] typeArr2) {
        C0565a.m1952a(typeArr2.length <= 1);
        C0565a.m1952a(typeArr.length == 1);
        if (typeArr2.length == 1) {
            C0565a.m1951a(typeArr2[0]);
            C0639b.m2067i(typeArr2[0]);
            C0565a.m1952a(typeArr[0] == Object.class);
            this.f1512b = C0639b.m2062d(typeArr2[0]);
            this.f1511a = Object.class;
            return;
        }
        C0565a.m1951a(typeArr[0]);
        C0639b.m2067i(typeArr[0]);
        this.f1512b = null;
        this.f1511a = C0639b.m2062d(typeArr[0]);
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        return new Type[]{this.f1511a};
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        return this.f1512b != null ? new Type[]{this.f1512b} : C0639b.f1506a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WildcardType) && C0639b.m2056a((Type) this, (Type) obj);
    }

    public int hashCode() {
        return (this.f1512b != null ? this.f1512b.hashCode() + 31 : 1) ^ (this.f1511a.hashCode() + 31);
    }

    public String toString() {
        if (this.f1512b != null) {
            return "? super " + C0639b.m2064f(this.f1512b);
        }
        if (this.f1511a == Object.class) {
            return "?";
        }
        return "? extends " + C0639b.m2064f(this.f1511a);
    }
}
