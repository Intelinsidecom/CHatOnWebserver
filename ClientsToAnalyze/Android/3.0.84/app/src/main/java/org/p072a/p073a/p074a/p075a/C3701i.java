package org.p072a.p073a.p074a.p075a;

import java.security.PrivilegedAction;

/* compiled from: EvictionTimer.java */
/* renamed from: org.a.a.a.a.i */
/* loaded from: classes.dex */
class C3701i implements PrivilegedAction<ClassLoader> {

    /* renamed from: a */
    private final ClassLoader f13642a;

    C3701i(ClassLoader classLoader) {
        this.f13642a = classLoader;
    }

    @Override // java.security.PrivilegedAction
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ClassLoader run() {
        Thread.currentThread().setContextClassLoader(this.f13642a);
        return null;
    }
}
