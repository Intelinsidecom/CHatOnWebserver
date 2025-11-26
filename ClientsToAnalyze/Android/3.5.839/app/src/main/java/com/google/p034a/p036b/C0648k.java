package com.google.p034a.p036b;

import com.google.p034a.InterfaceC0683q;
import java.lang.reflect.Type;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ConstructorConstructor.java */
/* renamed from: com.google.a.b.k */
/* loaded from: classes.dex */
class C0648k<T> implements InterfaceC0628ae<T> {

    /* renamed from: a */
    final /* synthetic */ InterfaceC0683q f1523a;

    /* renamed from: b */
    final /* synthetic */ Type f1524b;

    /* renamed from: c */
    final /* synthetic */ C0643f f1525c;

    C0648k(C0643f c0643f, InterfaceC0683q interfaceC0683q, Type type) {
        this.f1525c = c0643f;
        this.f1523a = interfaceC0683q;
        this.f1524b = type;
    }

    @Override // com.google.p034a.p036b.InterfaceC0628ae
    /* renamed from: a */
    public T mo2038a() {
        return (T) this.f1523a.m2174a(this.f1524b);
    }
}
