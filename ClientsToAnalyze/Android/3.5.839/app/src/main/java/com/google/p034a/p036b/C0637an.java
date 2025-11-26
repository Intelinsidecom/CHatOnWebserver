package com.google.p034a.p036b;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator.java */
/* renamed from: com.google.a.b.an */
/* loaded from: classes.dex */
final class C0637an extends AbstractC0634ak {

    /* renamed from: a */
    final /* synthetic */ Method f1504a;

    /* renamed from: b */
    final /* synthetic */ int f1505b;

    C0637an(Method method, int i) {
        this.f1504a = method;
        this.f1505b = i;
    }

    @Override // com.google.p034a.p036b.AbstractC0634ak
    /* renamed from: a */
    public <T> T mo2045a(Class<T> cls) {
        return (T) this.f1504a.invoke(null, cls, Integer.valueOf(this.f1505b));
    }
}
