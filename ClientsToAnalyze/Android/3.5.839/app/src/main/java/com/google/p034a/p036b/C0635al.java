package com.google.p034a.p036b;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator.java */
/* renamed from: com.google.a.b.al */
/* loaded from: classes.dex */
final class C0635al extends AbstractC0634ak {

    /* renamed from: a */
    final /* synthetic */ Method f1501a;

    /* renamed from: b */
    final /* synthetic */ Object f1502b;

    C0635al(Method method, Object obj) {
        this.f1501a = method;
        this.f1502b = obj;
    }

    @Override // com.google.p034a.p036b.AbstractC0634ak
    /* renamed from: a */
    public <T> T mo2045a(Class<T> cls) {
        return (T) this.f1501a.invoke(this.f1502b, cls);
    }
}
