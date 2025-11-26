package com.google.p034a.p036b;

import com.google.p034a.C0687u;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ConstructorConstructor.java */
/* renamed from: com.google.a.b.n */
/* loaded from: classes.dex */
class C0651n<T> implements InterfaceC0628ae<T> {

    /* renamed from: a */
    final /* synthetic */ Type f1529a;

    /* renamed from: b */
    final /* synthetic */ C0643f f1530b;

    C0651n(C0643f c0643f, Type type) {
        this.f1530b = c0643f;
        this.f1529a = type;
    }

    @Override // com.google.p034a.p036b.InterfaceC0628ae
    /* renamed from: a */
    public T mo2038a() {
        if (this.f1529a instanceof ParameterizedType) {
            Type type = ((ParameterizedType) this.f1529a).getActualTypeArguments()[0];
            if (type instanceof Class) {
                return (T) EnumSet.noneOf((Class) type);
            }
            throw new C0687u("Invalid EnumSet type: " + this.f1529a.toString());
        }
        throw new C0687u("Invalid EnumSet type: " + this.f1529a.toString());
    }
}
