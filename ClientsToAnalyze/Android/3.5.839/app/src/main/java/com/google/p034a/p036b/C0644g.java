package com.google.p034a.p036b;

import com.google.p034a.InterfaceC0683q;
import java.lang.reflect.Type;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ConstructorConstructor.java */
/* renamed from: com.google.a.b.g */
/* loaded from: classes.dex */
class C0644g<T> implements InterfaceC0628ae<T> {

    /* renamed from: a */
    final /* synthetic */ InterfaceC0683q f1514a;

    /* renamed from: b */
    final /* synthetic */ Type f1515b;

    /* renamed from: c */
    final /* synthetic */ C0643f f1516c;

    C0644g(C0643f c0643f, InterfaceC0683q interfaceC0683q, Type type) {
        this.f1516c = c0643f;
        this.f1514a = interfaceC0683q;
        this.f1515b = type;
    }

    @Override // com.google.p034a.p036b.InterfaceC0628ae
    /* renamed from: a */
    public T mo2038a() {
        return (T) this.f1514a.m2174a(this.f1515b);
    }
}
