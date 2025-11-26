package org.p138a.p139a.p140a.p141a;

import java.security.PrivilegedAction;

/* compiled from: EvictionTimer.java */
/* renamed from: org.a.a.a.a.i */
/* loaded from: classes.dex */
class C5213i implements PrivilegedAction<ClassLoader> {

    /* renamed from: a */
    private final ClassLoader f18997a;

    C5213i(ClassLoader classLoader) {
        this.f18997a = classLoader;
    }

    @Override // java.security.PrivilegedAction
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ClassLoader run() {
        Thread.currentThread().setContextClassLoader(this.f18997a);
        return null;
    }
}
