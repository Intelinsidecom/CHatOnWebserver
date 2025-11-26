package com.google.p034a.p036b;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ConstructorConstructor.java */
/* renamed from: com.google.a.b.l */
/* loaded from: classes.dex */
class C0649l<T> implements InterfaceC0628ae<T> {

    /* renamed from: a */
    final /* synthetic */ Constructor f1526a;

    /* renamed from: b */
    final /* synthetic */ C0643f f1527b;

    C0649l(C0643f c0643f, Constructor constructor) {
        this.f1527b = c0643f;
        this.f1526a = constructor;
    }

    @Override // com.google.p034a.p036b.InterfaceC0628ae
    /* renamed from: a */
    public T mo2038a() {
        try {
            return (T) this.f1526a.newInstance(null);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Failed to invoke " + this.f1526a + " with no args", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("Failed to invoke " + this.f1526a + " with no args", e3.getTargetException());
        }
    }
}
