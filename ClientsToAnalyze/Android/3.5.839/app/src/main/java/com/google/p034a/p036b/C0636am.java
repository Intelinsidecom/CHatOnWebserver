package com.google.p034a.p036b;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator.java */
/* renamed from: com.google.a.b.am */
/* loaded from: classes.dex */
final class C0636am extends AbstractC0634ak {

    /* renamed from: a */
    final /* synthetic */ Method f1503a;

    C0636am(Method method) {
        this.f1503a = method;
    }

    @Override // com.google.p034a.p036b.AbstractC0634ak
    /* renamed from: a */
    public <T> T mo2045a(Class<T> cls) {
        return (T) this.f1503a.invoke(null, cls, Object.class);
    }
}
