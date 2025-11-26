package com.google.p034a.p038c;

import com.google.p034a.p036b.C0565a;
import com.google.p034a.p036b.C0639b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: TypeToken.java */
/* renamed from: com.google.a.c.a */
/* loaded from: classes.dex */
public class C0664a<T> {

    /* renamed from: a */
    final Class<? super T> f1567a;

    /* renamed from: b */
    final Type f1568b;

    /* renamed from: c */
    final int f1569c;

    protected C0664a() {
        this.f1568b = m2101a(getClass());
        this.f1567a = (Class<? super T>) C0639b.m2063e(this.f1568b);
        this.f1569c = this.f1568b.hashCode();
    }

    C0664a(Type type) {
        this.f1568b = C0639b.m2062d((Type) C0565a.m1951a(type));
        this.f1567a = (Class<? super T>) C0639b.m2063e(this.f1568b);
        this.f1569c = this.f1568b.hashCode();
    }

    /* renamed from: a */
    static Type m2101a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C0639b.m2062d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    /* renamed from: a */
    public final Class<? super T> m2103a() {
        return this.f1567a;
    }

    /* renamed from: b */
    public final Type m2104b() {
        return this.f1568b;
    }

    public final int hashCode() {
        return this.f1569c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0664a) && C0639b.m2056a(this.f1568b, ((C0664a) obj).f1568b);
    }

    public final String toString() {
        return C0639b.m2064f(this.f1568b);
    }

    /* renamed from: a */
    public static C0664a<?> m2100a(Type type) {
        return new C0664a<>(type);
    }

    /* renamed from: b */
    public static <T> C0664a<T> m2102b(Class<T> cls) {
        return new C0664a<>(cls);
    }
}
