package com.google.p034a.p036b;

import java.lang.reflect.Type;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ConstructorConstructor.java */
/* renamed from: com.google.a.b.j */
/* loaded from: classes.dex */
class C0647j<T> implements InterfaceC0628ae<T> {

    /* renamed from: a */
    final /* synthetic */ Class f1519a;

    /* renamed from: b */
    final /* synthetic */ Type f1520b;

    /* renamed from: c */
    final /* synthetic */ C0643f f1521c;

    /* renamed from: d */
    private final AbstractC0634ak f1522d = AbstractC0634ak.m2044a();

    C0647j(C0643f c0643f, Class cls, Type type) {
        this.f1521c = c0643f;
        this.f1519a = cls;
        this.f1520b = type;
    }

    @Override // com.google.p034a.p036b.InterfaceC0628ae
    /* renamed from: a */
    public T mo2038a() {
        try {
            return (T) this.f1522d.mo2045a(this.f1519a);
        } catch (Exception e) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + this.f1520b + ". Register an InstanceCreator with Gson for this type may fix this problem.", e);
        }
    }
}
